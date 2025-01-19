package flipper;

import util.Credit;
import util.Round;

import java.sql.SQLOutput;

public class ReadyState extends State {
    private final Flipper flipper;



    public ReadyState(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        Credit.getInstance().setCredit(1);
        System.out.println("Coin inserted. Your current credit: " + Credit.getInstance().getCredit());

    }

    @Override
    public void pressStart() {

        //TODO: Das müssen wir sicher noch einfacher machen
        switch (Round.getInstance().getRound()) {
            case 0:
                Round.getInstance().updateRound();
                Credit.getInstance().setCredit(-1);
                flipper.setState(new PlayingState(flipper));
                System.out.println("Game started. Current round: " + Round.getInstance().getRound());
                break;
            case 1, 2, 3:
                Round.getInstance().updateRound();
                flipper.setState(new PlayingState(flipper));
                System.out.println("Game started. Current round: " + Round.getInstance().getRound()); // TODO: Hier sehe ich einen möglichen Bug:
                //Weil in Runde 3 läuft ja noch ein gültiges Spiel an. Aber wenn du die Runde zuerst updatest und DANN die Print-Ausgabe machst, dann sagt die jetzt ja, dass gerade Runde 4 läuft
                //--> Print einfach in der Reihenfolge vor das .updateRound() setzen?
                break;
            case 4:
                if (Credit.getInstance().getCredit() > 0) {
                    Round.getInstance().resetRound();
                    Round.getInstance().updateRound();
                    Credit.getInstance().setCredit(-1);
                    flipper.setState(new PlayingState(flipper));
                    System.out.println("A new game has started. Current round: " + Round.getInstance().getRound());
                } else {
                    System.out.println("You don't have enough credits to start a new game.");
                    flipper.setState(new NoCreditState(flipper));
                }
                break;
            default:
                flipper.setState(new NoCreditState(flipper));
        }

    }


}

