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
        System.out.println("Münze eingeworfen! Sie können nun ein neues Spiel starten. Aktueller Credit: " + Credit.getInstance().getCredit());
        flipper.setState(new ReadyState(flipper));
    }

    @Override
    public void pressStart() {
        System.out.println("Kein Credit. Bitte werfen Sie eine Münze ein, um ein Spiel zu starten.");
    }
}
