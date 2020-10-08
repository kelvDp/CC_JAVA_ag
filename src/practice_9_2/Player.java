
package practice_9_2;


public class Player {
    
    private String playerName;
    // no arg constructor
    // can set in one line
    public Player() {}

    // arg constructor
    public Player(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
}
