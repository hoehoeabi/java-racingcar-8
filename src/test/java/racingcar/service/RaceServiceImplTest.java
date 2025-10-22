package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entity.Car;
import racingcar.repository.Repository;
import racingcar.validate.Validators;

import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceServiceImplTest {

    // 단위 테스트 대상
    private RaceServiceImpl raceService;

    // 테스트를 위한 가짜들
    private Repository<Car> fakeRepository;
    private Validators fakeValidators;
    private FakeMovementStrategy fakeMovementStrategy;

    @BeforeEach
    void setUp() {
        this.fakeRepository = new FakeCarRepository();
        this.fakeValidators = new FakeValidators();
        this.fakeMovementStrategy = new FakeMovementStrategy(true);

        this.raceService = new RaceServiceImpl(fakeRepository
                ,fakeValidators
                ,fakeMovementStrategy);
    }

    @Test
    @DisplayName("자동차 이름을 쉼표로 구분하여 생성한다")
    void createCars_성공() {
        // given
        String carNames = "pobi , crong ";

        // when
        raceService.createCars(carNames);

        // then
        assertThat(fakeRepository.getAll())
                .hasSize(2)
                .map(Car::getName) // List<Car> -> List<String>
                .containsExactly("pobi", "crong");
    }

    @Test
    @DisplayName("Validator가 예외를 던지면 save가 호출되지 않아 리스트는 비어있다")
    void createCars_실패_Validator가_예외던짐() {
        // given
        String carNames = "pobi"; // 실패를 유발할 입력값 -> 굳이 선언 안해도 될거같습니다.

        // 예외를 던지는 "실패용" Validator 정의
        Validators failingValidator = new FakeValidators() {
            @Override
            public void inputValidate(String input) {
                throw new IllegalArgumentException("테스트용 예외");
            }
        };

        // "실패용" Validator를 주입한 Service 생성
        RaceService localRaceService = new RaceServiceImpl(fakeRepository, failingValidator, fakeMovementStrategy);

        // when
        // 예외가 발생하는지 확인. 예외가 발생해야 정상.
        assertThrows(IllegalArgumentException.class, () -> {
            localRaceService.createCars(carNames);
        });

        // then
        // 예외가 발생했으므로, save가 호출되지 않았어야 함
        // 따라서 fakeRepository의 리스트는 비어있어야 함
        assertThat(fakeRepository.getAll()).isEmpty();
    }

    // 이건 validator단위테스트로 대체
    @Test
    void duplicateNameCheck() {
    }

    @Test
    @DisplayName("자동차가 잘 움직이는지 검증")
    void doOneRace_성공() {
        // given
        fakeRepository.save(new Car("pobi",fakeMovementStrategy));
        fakeRepository.save(new Car("babi",fakeMovementStrategy));

        // when
        raceService.doOneRace();

        // then
        assertThat(fakeRepository.getAll())
                .extracting(Car::getPosition)
                .containsExactly(1, 1);
    }

    @Test
    @DisplayName("자동차가 가만히 있는지 검증")
    void doOneRace_실패() {
        // given
        FakeMovementStrategy fakeMovementStrategy = new FakeMovementStrategy(false);

        fakeRepository.save(new Car("pobi",fakeMovementStrategy));
        fakeRepository.save(new Car("babi",fakeMovementStrategy));

        // when
        raceService.doOneRace();

        // then
        int positionSum = fakeRepository.getAll().stream()
                .mapToInt(Car::getPosition)
                .sum();

        assertThat(positionSum).isEqualTo(0);
    }

    @Test
    @DisplayName("동시 우승!")
    void getWinners_동시_우승() {
        // given
        Car car1 = new Car("pobi",fakeMovementStrategy);
        Car car2 = new Car("babi",fakeMovementStrategy);
        fakeRepository.save(car1);
        fakeRepository.save(car2);
        car1.move();
        car2.move();

        // when
        Queue<String> winners = raceService.getWinners();

        // then
        int winnersSize = winners.size();
        assertThat(winnersSize).isEqualTo(2);
    }

    @Test
    @DisplayName("단독 우승!")
    void getWinners_단독_우승(){
        // given
        Car car1 = new Car("pobi",fakeMovementStrategy);
        Car car2 = new Car("babi",fakeMovementStrategy);
        fakeRepository.save(car1);
        fakeRepository.save(car2);
        car1.move();

        // when
        Queue<String> winners = raceService.getWinners();

        // then
        int winnersSize = winners.size();
        assertThat(winnersSize).isEqualTo(1);
    }

}