package util;

public class Credit {

    private static Credit instance;
    private int credit;

    private Credit() {
        this.credit = 0;
    }

    public static Credit getInstance() {
        if (instance == null) {
            instance = new Credit();
        }
        return instance;
    }

    public void setCredit(int insertedCredit) {
        credit += insertedCredit;
    }

    public int getCredit() {
        return credit;
    }
}
