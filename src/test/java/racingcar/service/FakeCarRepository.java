package racingcar.service;

import racingcar.entity.Car;
import racingcar.repository.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Repository 인터페이스를 구현하는 "테스트용" 클래스
class FakeCarRepository implements Repository<Car> {

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
