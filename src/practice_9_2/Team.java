
package practice_9_2;

public class Team {

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

    private String teamName;
    private Player[] playerArray;

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

}
