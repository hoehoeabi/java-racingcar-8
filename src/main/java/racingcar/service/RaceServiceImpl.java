package racingcar.service;

import racingcar.entity.Car;
import racingcar.repository.Repository;
import racingcar.validate.Validators;

import java.util.*;
import java.util.stream.Collectors;

public class RaceServiceImpl implements RaceService {

    private final Repository<Car> repository;
    private final Validators validators;

    public RaceServiceImpl(Repository<Car> repository,
                           Validators validators) {
        this.repository = repository;
        this.validators = validators;
    }

    @Override
    public void createCars(String carsName) {
        validators.inputValidate(carsName);
        String[] names = carsName.split(",");

        for(String name:names){
            repository.save(new Car(name.trim()));
        }
    }

    @Override
    public void duplicateNameCheck() {
        List<Car> carsList = repository.getAll();
        Set<String> carNamesSet = carsList.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());
        validators.nameDuplicateValidate(carsList.size(),carNamesSet.size());
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
            if(car.getPosition()>longestPosition){
                longestPosition =car.getPosition();
                winners.clear();
                winners.add(car.getName());
                continue;
            }
            if(car.getPosition()==longestPosition){
                winners.add(car.getName());
            }
        }

        return new LinkedList<>(winners);
    }

}
