package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    final static String DELIMETER= ",";

    private final List<Car> cars;
    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void attemptRaceForAll() {
        for (Car car : cars) {
            car.attemptRace();
        }
    }

    public List<String> getCurrentPositions() {
        return cars.stream()
                .map(car -> car.getName() + " : " + car.currentPosition())
                .collect(Collectors.toList());
    }


    public Cars(String input) {
        this.cars = Arrays.stream(input.split(DELIMETER, -1))
                .peek(name -> {
                    if(name.length() > 5){
                        throw new IllegalArgumentException("이름이 5글자를 초과 했습니다.");
                    }
                })
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> findWinner() {

        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }


}

