package practice_8_3;

import practice_8_3.utility.GameUtils;

public class Game {

    public Team homeTeam;
    public Team awayTeam;
    public Goal[] goals;

    // play game method that recieves args
    public void playGame(int maxGoals) {

        // create random nr of goals
        // int nrOfGoals = (int) (Math.random() * 7);
        int nrOfGoals = (int) (Math.random() * (maxGoals + 1));

        // goal array
        Goal[] theGoals = new Goal[nrOfGoals];
        this.goals = theGoals;

        // addGoal method from Util class
        GameUtils.addGameGoals(this); // since already in game class, can just use this to refernce game object
    }

    // playgame method that does not recieve args
    public void playGame() {
        // simply call the other playgame method here with a default arg param
        // instead of hard coding new code here
        playGame(7);
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
