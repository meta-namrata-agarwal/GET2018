package ds_Assignment3JulyQues3;

/**
 * 
 * @author Namrata Agarwal
 *
 */
public class ListOfBowlers {
    private String bowlerName;
    private int ballToEachBowler;

    public ListOfBowlers(String bowlerName, int ballToEachBowler) {
        this.bowlerName = bowlerName;
        this.ballToEachBowler = ballToEachBowler;
    }

    public void setBowlerName(String bowlerName) {
        this.bowlerName = bowlerName;
    }

    public String getBowlerName() {
        return bowlerName;
    }

    public void setballToEachBowler(int ballToEachBowler) {
        this.ballToEachBowler = ballToEachBowler;
    }

    public int getballToEachBowler() {
        return ballToEachBowler;
    }
}
