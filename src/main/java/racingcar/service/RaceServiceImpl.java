package racingcar.service;

import racingcar.entity.Car;
import racingcar.repository.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RaceServiceImpl implements RaceService {

    private final Repository<Car> repository;

    public RaceServiceImpl(Repository<Car> repository) {
        this.repository = repository;
    }

    @Override
    public void createCars(String carsName) {
        String[] names = carsName.split(",");
        for(String name:names){
            repository.save(new Car(name.trim()));
        }
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
