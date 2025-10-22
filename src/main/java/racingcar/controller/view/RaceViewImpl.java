package racingcar.controller.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.entity.Car;

import java.util.List;
import java.util.Queue;

public class RaceViewImpl implements RaceView {

    @Override
    public String carsNameInputView(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    @Override
    public String raceRepetitionInputView(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    @Override
    public void outcomeTopView() {
        Console.close();
        System.out.println("\n실행 결과");
    }

    @Override
    public void raceFlowResultView(List<Car> cars) {
        for (Car car : cars) {
            drawCarMovement(car);
        }

        System.out.println();
    }

    private static void drawCarMovement(Car car) {
        System.out.print(car.getName()+" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void showWinnerOutputView(Queue<String> winners) {
        System.out.print("최종 우승자 : "+ winners.poll());
        if (!winners.isEmpty()) {
            System.out.print(", " + winners.poll());
        }
//        String winnerList = winners.stream()
//                .collect(Collectors.joining(", "));
//
//        System.out.println("최종 우승자 : " + winnerList);

    }

}
