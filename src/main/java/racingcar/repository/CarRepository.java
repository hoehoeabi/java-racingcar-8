package racingcar.repository;

import racingcar.entity.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRepository implements Repository<Car> {
    private final List<Car> cars = new ArrayList<>();

    @Override
    public void save(Car entity) {

        cars.add(entity);
    }

    @Override
    public List<Car> getAll() {
        return Collections.unmodifiableList(cars);
    }
}
