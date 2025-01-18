package flipper;

import util.Credit;

public class NoCreditState extends State{
    private final Flipper flipper;


    public NoCreditState(Flipper flipper) {
        this.flipper = flipper;

    }

    @Override
    public void insertCoin() {
        Credit.getInstance().setCredit(1);
        System.out.println("Coin inserted. You can now start a Game. Current credit: " + Credit.getInstance().getCredit());
        flipper.setState(new ReadyState(flipper));
    }

    @Override
    public void pressStart() {
        System.out.println("No credit. Please insert coin to play.");
    }
}
