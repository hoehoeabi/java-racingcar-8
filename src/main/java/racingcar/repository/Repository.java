package racingcar.repository;

import java.util.List;

public interface Repository<T> {

    /**
     *
     * @param entity 저장할 객체
     * 객체를 저장소에 저장
     */
    void save(T entity);

    /**
     * 모든 객체들을 리스트로 반환
     */
    List<T> getAll();

}
