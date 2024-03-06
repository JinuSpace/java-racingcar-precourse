package racingcar;

import java.util.List;

public class RacingController {
    private final RacingView view = new RacingView();
    private final RacingService service = new RacingService();

    public void startGame() {
        Cars cars;
        int count = 0;

        String raedCount = "";

        while (true) {
            try {
                view.printCarsManual();
                String inputNames = view.input();
                cars = service.saveCars(inputNames);
                break;
            } catch (IllegalArgumentException e) {
                view.printError("이름이 5글자를 초과 했습니다.");
            }
        }

        while (true) {
            try {
                view.printCountManual();
                raedCount = view.input();
                count = service.changeCount(raedCount);
                break;
            } catch (IllegalArgumentException e) {
                view.printError("잘못된 인자가 입력되었습니다.");
            }
        }

        view.printResultManual();
        for (int i = 0; i < count; i++) {
            List<String> s = service.race(cars);
            view.printScore(s);
        }

        String winners = service.findWinners(cars);
        view.printWinner(winners);

    }
}
