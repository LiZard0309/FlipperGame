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
        System.out.println("Münze eingeworfen! Aktueller Credit: " + Credit.getInstance().getCredit());

    }

    @Override
    public void pressStart() {

        //TODO: Das müssen wir sicher noch einfacher machen
        switch (Round.getInstance().getRound()) {
            case 0:
                Round.getInstance().updateRound();
                Credit.getInstance().setCredit(-1);
                flipper.setState(new PlayingState(flipper));
                System.out.println("Spiel startet. Aktuelle Runde: " + Round.getInstance().getRound());
                break;
            case 1, 2:
                Round.getInstance().updateRound();
                flipper.setState(new PlayingState(flipper));
                System.out.println("Spiel startet. Aktuelle Runde: " + Round.getInstance().getRound());
                break;
            case 3:
                if (Credit.getInstance().getCredit() > 0) {
                    Round.getInstance().resetRound();
                    Round.getInstance().updateRound();
                    Credit.getInstance().setCredit(-1);
                    flipper.setState(new PlayingState(flipper));
                    System.out.println("Sie haben ein neues Spiel gestartet. Aktuelle Runde: " + Round.getInstance().getRound());
                } else {
                    System.out.println("Sie haben nicht genügend Credits, um ein neues Spiel zu starten. Um weiterzuspielen, werfen Sie bitte noch eine Münze ein.");
                    flipper.setState(new NoCreditState(flipper));
                }
                break;
            default:
                flipper.setState(new NoCreditState(flipper));
        }

    }


}

