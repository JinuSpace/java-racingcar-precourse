package racingcar;
public class Util {
    public int changeCount(String input) throws IllegalArgumentException {
        int count = Integer.parseInt(input);

        checkCountRange(count);

        return count;
    }

    public void checkCountRange(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }
}