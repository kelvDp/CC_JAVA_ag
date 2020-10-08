
package practice_10_1;

import practice_10_1.utility.GameUtils;

public class Game {

    private Team homeTeam;
    private Team awayTeam;
    private Goal[] goals;

    // constructors

    public Game(Team home, Team away) {
        this.homeTeam = home;
        this.awayTeam = away;
    }

    public void playGame(int maxGoals) {
        int numberOfGoals = (int) (Math.random() * maxGoals + 1);
        Goal[] theGoals = new Goal[numberOfGoals];
        this.goals = theGoals;
        GameUtils.addGameGoals(this);
    }

    public void playGame() {
        playGame(6);
    }

    public String getDescription() {
        int homeTeamGoals = 0;
        int awayTeamGoals = 0;

        StringBuilder returnString = new StringBuilder();
        returnString.append("\n" + homeTeam.getTeamName() + " vs. " + awayTeam.getTeamName() + "\n");

        for (Goal currGoal : this.goals) {

            if (currGoal.getTheTeam() == homeTeam) {
                homeTeamGoals++;
            } else {
                awayTeamGoals++;
            }

            returnString.append("Goal scored after " + currGoal.getTheTime() + " mins by "
                    + currGoal.getThePlayer().getPlayerName() + " of " + currGoal.getTheTeam().getTeamName() + "\n");
        }

        if (homeTeamGoals == awayTeamGoals) {
            returnString.append("It's a Tie!");
            homeTeam.increment(1);
            awayTeam.increment(1);
        } else if (homeTeamGoals > awayTeamGoals) {
            returnString.append(homeTeam.getTeamName() + " wins!");
            homeTeam.increment(2);
        } else {
            returnString.append(awayTeam.getTeamName() + " wins!");
            awayTeam.increment(2);
        }

        returnString.append("\nHome team: " + homeTeamGoals + ", Visiting team: " + awayTeamGoals);

        return returnString.toString();
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Goal[] getGoals() {
        return goals;
    }

    public void setGoals(Goal[] goals) {
        this.goals = goals;
    }

}
