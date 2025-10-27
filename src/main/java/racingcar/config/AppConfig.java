package racingcar.config;

import racingcar.controller.RaceController;
import racingcar.controller.view.RaceView;
import racingcar.entity.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.Repository;
import racingcar.service.RaceService;
import racingcar.service.RaceServiceImpl;
import racingcar.entity.strategy.MovementStrategy;
import racingcar.entity.strategy.RandomMovementStrategy;
import racingcar.validate.Validators;
import racingcar.validate.ValidatorsImpl;
import racingcar.controller.view.RaceViewImpl;

import static racingcar.validate.pattern.GameRules.*;

public class AppConfig {

    public Repository<Car> repsitory(){
        return new CarRepository();
    }

    public Validators racingValidators() {
        return new ValidatorsImpl(
                ONLY_ONE_CAR_PATTERN,  // GameRules.ONLY_ONE_CAR_PATTERN
                RACING_CARS_PATTERN,   // GameRules.RACING_CARS_PATTERN
                MAX_RACE_REPETITION    // GameRules.MAX_RACE_REPETITION
        );
    }

    public MovementStrategy movementStrategy() {
        return new RandomMovementStrategy();
    }

    public RaceService service(){
        return new RaceServiceImpl(repsitory(),racingValidators(),movementStrategy());
    }

    public RaceView raceView(){

        return new RaceViewImpl();
    }

    public RaceController raceController(){

        return new RaceController(raceView()
                ,racingValidators()
                ,service());
    }

}
