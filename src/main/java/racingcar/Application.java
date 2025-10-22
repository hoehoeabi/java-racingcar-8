package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RaceController;

public class Application {
    public static void main(String[] args) {

        try{
            new AppConfig()
                    .raceController()
                    .raceStart();
        } catch (Exception e){
            System.out.println("[ERROR] : " + e.getMessage());
        }

    }
}
