
package practice_10_1;

public class Team {

    
    private String teamName;
    private Player[] playerArray;
    private int pointsTotal;
    
    // constructors

    public Team() {}

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, Player[] players) {
        // this.teamName = teamName;
        // can use constructor already made with 'this' method
        this(teamName);
        this.playerArray = players;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Player[] getPlayerArray() {
        return playerArray;
    }

    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }

    public int getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(int point) {
        this.pointsTotal = point;
    }

    public void increment(int value) {
        this.pointsTotal += value;
    }

}
