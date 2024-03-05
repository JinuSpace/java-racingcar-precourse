package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingService {
    private final Util util = new Util();

    public Cars saveCars(String input) throws IllegalArgumentException {

        return new Cars(input);
    }

    public List<String> race(Cars cars) throws IllegalArgumentException {
        cars.attemptRaceForAll();

        return cars.getCurrentPositions();
    }

    public int changeCount(String input) throws IllegalArgumentException {

        return util.changeCount(input);
    }

    public String findWinners(Cars cars) {
        List<Car> winners = cars.findWinner();

        return makeWinnerFormat(winners);
    }

    public String makeWinnerFormat(List<Car> cars) {

        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
