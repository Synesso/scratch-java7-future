package jem;

public class Result {
    public final int value;
    public Result(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Peon #" + value;
    }
}
