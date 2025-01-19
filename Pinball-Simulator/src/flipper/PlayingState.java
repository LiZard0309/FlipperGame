package flipper;

import util.Credit;

public class PlayingState extends State {
    private final Flipper flipper;

    public PlayingState(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        Credit.getInstance().setCredit(1);
        System.out.println("Münze eingeworfen! Aktueller Credit: " + Credit.getInstance().getCredit());

    }

    @Override
    public void pressStart() {
        System.out.println("Sie spielen ein Spiel entwickelt von Maria Feher-Lehrner and Lisa Hofbauer.");
    }
}
