package racingcar.controller;

import racingcar.entity.Car;
import racingcar.service.RaceService;
import racingcar.validate.Validators;
import racingcar.controller.view.RaceView;

import java.util.List;
import java.util.Queue;

public class RaceController {

    private final RaceView view;
    private final Validators validators;
    private final RaceService raceService;

    public RaceController(RaceView view
            , Validators validators
            ,RaceService raceService) {
        this.view = view;
        this.validators = validators;
        this.raceService = raceService;
    }

    public void raceStart() {
        String input = view.carsNameInputView();
        raceService.createCars(input);
        raceService.duplicateNameCheck();

        String raceReps = view.raceRepetitionInputView();
        validators.repsValidate(raceReps);

        view.outcomeTopView();

        for(int i=0;i<Integer.parseInt(raceReps);i++){
            List<Car> updatedCars = raceService.doOneRace();
            view.raceFlowResultView(updatedCars);
        }

        Queue<String> winners = raceService.getWinners();
        view.showWinnerOutputView(winners);
    }

}
