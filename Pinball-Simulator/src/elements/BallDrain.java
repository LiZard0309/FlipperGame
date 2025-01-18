package elements;

import score.Score;

public class BallDrain extends FlipperElement{
    @Override
    public int hit(){
        System.out.println("Ball Drain getroffen. Ball geht verloren und aktuelle Runde wird beendet.");
        return -1; //Platzhalter-Return
    }
}
