package racingcar.service;

import racingcar.entity.Car;
import racingcar.repository.Repository;
import racingcar.entity.strategy.MovementStrategy;
import racingcar.validate.Validators;

import java.util.*;

public class RaceServiceImpl implements RaceService {

    private final Repository<Car> repository;
    private final Validators validators;
    private final MovementStrategy movementStrategy;

    public RaceServiceImpl(Repository<Car> repository
                            , Validators validators
                            , MovementStrategy movementStrategy) {
        this.repository = repository;
        this.validators = validators;
        this.movementStrategy = movementStrategy;
    }

    @Override
    public void createCars(String input) {
        validators.inputValidate(input);

        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        validators.nameDuplicateValidate(carNames);

        carNames.stream()
                .map(name -> new Car(name, movementStrategy))
                .forEach(repository::save);
    }


    @Override
    public List<Car> doOneRace() {
        List<Car> cars = repository.getAll();

        for(Car car:cars){
            car.move();
        }

        return cars;
    }

    @Override
    public Queue<String> getWinners() {
        List<Car> cars = repository.getAll();
        List<String> winners = new ArrayList<>();
        int longestPosition = Integer.MIN_VALUE;

        for(Car car:cars){
            longestPosition = getLongestPosition(car
                    , longestPosition
                    , winners);
        }

        return new LinkedList<>(winners);
    }

    private static int getLongestPosition(Car car
            , int longestPosition
            , List<String> winners) {
        if(car.getPosition()> longestPosition){
            longestPosition = car.getPosition();
            winners.clear();
            winners.add(car.getName());
            return longestPosition;
        }
        if(car.getPosition()== longestPosition){
            winners.add(car.getName());
        }
        return longestPosition;
    }

}
