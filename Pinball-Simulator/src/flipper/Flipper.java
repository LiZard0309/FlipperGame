package flipper;

public class Flipper {
    private State state;

    public Flipper() {
        state = new NoCreditState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void testGame() {
        //nur für uns zum Testen, können wir dann wieder rauslöschen
        state.pressStart();
        state.insertCoin();
        state.pressStart();
        state.insertCoin();
        state.insertCoin();
        state.pressStart();
    }

    public void playGameOne() {
        //TODO: ganz am Ende: tatsächlichen Spielablauf implementieren (mit drei Runden und Anfang (Credit-Einwurf etc.)
    }

    public void playGameTwo() {
        //TODO: ganz am Ende: tatsächlichen Spielablauf implementieren
    }
}
