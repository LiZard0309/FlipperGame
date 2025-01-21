package flipper;

import util.Credit;
import util.Round;
import util.Score;

import java.sql.SQLOutput;
import java.util.Scanner;

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
                //case 0 means that no round has been played yet. First round is about to start.
                Round.getInstance().updateRound();
                Credit.getInstance().setCredit(-1);
                flipper.setState(new PlayingState(flipper));
                System.out.println("Spiel startet. Aktuelle Runde: " + Round.getInstance().getRound());
                break;
            case 1, 2:
                //case 1 and 2 means that the 2nd or 3rd round is about to start.
                Round.getInstance().updateRound();
                flipper.setState(new PlayingState(flipper));
                System.out.println("Spiel startet. Aktuelle Runde: " + Round.getInstance().getRound());
                break;
            case 3:
                //case 3 means that 4th round is about to start.
                if (Credit.getInstance().getCredit() > 0) {
                    Round.getInstance().resetRound();
                    Round.getInstance().updateRound();
                    Credit.getInstance().setCredit(-1);
                    flipper.setState(new PlayingState(flipper));
                    Score.getInstance().resetScore();
                    flipper.resetGame(); //all elements get reset to original state.
                    System.out.println("Sie haben ein neues Spiel gestartet. Aktuelle Runde: " + Round.getInstance().getRound());
                } else {
                    System.out.println("Sie haben nicht genügend Credits, um ein neues Spiel zu starten. Um weiterzuspielen, werfen Sie bitte noch eine Münze ein.");
                    flipper.resetGame();
                    Score.getInstance().resetScore();
                    flipper.setState(new NoCreditState(flipper));
                }
                break;
            default:
                flipper.setState(new NoCreditState(flipper));
        }

        //vermutlich hier (oder eine Ebene drüber im Flipper) den Code für Ablauf einer Runde siehe restliches Code-Snippet in Main
        //für Länge von elements Array für Begrenzung random index zahl: siehe flipper.getTotalAmountOfElements()

    }


}

