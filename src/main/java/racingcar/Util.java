package racingcar;
public class Util {
    private Util(){
    }
    public static int changeCount(String input) throws IllegalArgumentException {
        int count = Integer.parseInt(input);

        checkCountRange(count);

        return count;
    }

    public static void checkCountRange(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }
    }
}