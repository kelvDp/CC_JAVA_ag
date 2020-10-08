package practice_8_2;

import practice_8_2.utility.GameUtils;

public class Game {

    public Team homeTeam;
    public Team awayTeam;
    public Goal[] goals;

    // play game method
    public void playGame() {

        // create random nr of goals
        int nrOfGoals = (int) (Math.random() * 7);

        // goal array
        Goal[] theGoals = new Goal[nrOfGoals];
        this.goals = theGoals;

        // addGoal method from Util class
        GameUtils.addGameGoals(this); // since already in game class, can just use this to refernce game object
    }

    // game desc method
    public String getDesc() {

        StringBuilder output = new StringBuilder();

        for (Goal goal : this.goals) {
            output.append("Goal scored after " + goal.theTime + " minutes, by " + goal.thePlayer.playerName + " of "
                    + goal.theTeam.teamName + "\n");
        }

        return output.toString();
    }
}
