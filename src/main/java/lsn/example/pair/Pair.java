package lsn.example.pair;

public class Pair {

    private final int lowerValue;
    private final int higherValue;

    public Pair(int lowerValue, int higherValue) {
        this.lowerValue = lowerValue;
        this.higherValue = higherValue;
    }

    public int getLowerValue() {
        return lowerValue;
    }

    public int getHigherValue() {
        return higherValue;
    }
}
