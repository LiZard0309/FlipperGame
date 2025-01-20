package util;//Score.Score Class als Singleton

public class Score {

    private static Score instance;
    private int score;

    private Score() {
        this.score = 0;
    }

    public static Score getInstance() {
        if (instance == null) {
            instance = new Score();
        }
        return instance;
    }

    public void updateScore(int points) {
        score += points;
        System.out.println("Score updated! Current score: " + score);
    }

    public int getScore() {
        return score;
    }

    public void resetScore(){
        score = 0;
    }
}
