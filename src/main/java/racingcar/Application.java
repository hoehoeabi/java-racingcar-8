package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.AppConfig;

public class Application {
    public static void main(String[] args) {

        try{
            new AppConfig()
                    .raceController()
                    .raceStart();
        } catch (Exception e){
            System.out.println("[ERROR] : " + e.getMessage());
        } finally {
            Console.close();
        }

    }
}
