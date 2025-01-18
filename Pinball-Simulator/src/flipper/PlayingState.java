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
        System.out.println("Coin inserted. Your current credit: " + Credit.getInstance().getCredit());

    }

    @Override
    public void pressStart() {
        System.out.println("You are currently playing a game developed by Maria Feher-Lehrner and Lisa Hofbauer.");
    }
}
