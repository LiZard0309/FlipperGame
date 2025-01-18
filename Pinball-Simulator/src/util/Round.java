package util;

public class Round {

    private static Round instance;
    private int round;

    private Round() {
        this.round = 0;
    }

    public static Round getInstance() {
        if (instance == null) {
            instance = new Round();
        }
        return instance;
    }

    public void updateRound() {
        round += 1;
    }

    public void resetRound() {
        round = 0;
    }

    public int getRound() {
        return round;
    }
}
