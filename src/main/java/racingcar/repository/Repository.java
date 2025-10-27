package racingcar.repository;

import java.util.List;

public interface Repository<T> {

    /**
     *
     * @param entity 저장할 객체
     *
     * @implSpec
     * 객체를 저장소에 저장해줍니다.
     */
    void save(T entity);

    /**
     * @implSpec
     * 모든 객체들을 리스트로 반환해줍니다.
     */
    List<T> getAll();

}
