package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void attemptRace() {
        if (Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE) >= 4) {
            position++;
        }
    }

    public String currentPosition() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }


}
