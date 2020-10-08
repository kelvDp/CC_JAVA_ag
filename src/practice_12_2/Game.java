
package practice_12_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Game {

    private Team homeTeam;
    private Team awayTeam;
    private GameEvent[] GameEvents;
    private LocalDateTime theDateTime;

    public Game(Team homeTeam, Team awayTeam, LocalDateTime dateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.theDateTime = dateTime;
    }

    // public void playGame(int maxGameEvents) {
    // int numberOfGameEvents = (int) (Math.random() * maxGameEvents + 1);
    // GameEvent[] theGameEvents = new GameEvent[numberOfGameEvents];
    // this.setGameEvents(theGameEvents);
    // GameUtils.addGameGameEvents(this);
    // }

    public void playGame() {

        ArrayList<GameEvent> eventList = new ArrayList<>();
        GameEvent currEvent;

        for (int i = 1; i <= 90; i++) {
            if (Math.random() > 0.95) {
                // System.out.println(i);
                currEvent = (Math.random() > 0.5 ? new Goal() : new Possession());
                currEvent.setTheTeam(Math.random() > 0.5 ? homeTeam : awayTeam);
                currEvent.setThePlayer(currEvent.getTheTeam()
                        .getPlayerArray()[(int) (Math.random() * currEvent.getTheTeam().getPlayerArray().length)]);
                currEvent.setTheTime(i);
                eventList.add(currEvent);
            }
        }

        this.GameEvents = new GameEvent[eventList.size()];
        eventList.toArray(GameEvents);
    }

    public String getDescription() {

        int homeTeamGameEvents = 0;
        int awayTeamGameEvents = 0;
        StringBuilder returnString = new StringBuilder();

        returnString.append(this.getHomeTeam().getTeamName() + " vs. " + this.getAwayTeam().getTeamName() + "\n"
                + "Date: " + this.theDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n");

        for (GameEvent currGameEvent : this.getGameEvents()) {

            if (currGameEvent.getTheTeam() == homeTeam) {
                homeTeamGameEvents++;
                homeTeam.incGoalsTotal(1);
            } else {
                awayTeamGameEvents++;
                awayTeam.incGoalsTotal(1);
            }

            returnString.append(currGameEvent + " after " + currGameEvent.getTheTime() + " mins by "
                    + currGameEvent.getThePlayer().getPlayerName() + " of " + currGameEvent.getTheTeam().getTeamName()
                    + "\n");
        }

        if (homeTeamGameEvents == awayTeamGameEvents) {
            returnString.append("It's a draw!");
            this.homeTeam.incPointsTotal(1);
            this.awayTeam.incPointsTotal(1);
        } else if (homeTeamGameEvents > awayTeamGameEvents) {
            returnString.append(homeTeam.getTeamName() + " win");
            this.homeTeam.incPointsTotal(1);
        } else {
            returnString.append(awayTeam.getTeamName() + " win");
            this.awayTeam.incPointsTotal(1);
        }
        returnString.append(" (" + homeTeamGameEvents + " - " + awayTeamGameEvents + ") \n");

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

    public GameEvent[] getGameEvents() {
        return GameEvents;
    }

    public void setGameEvents(GameEvent[] GameEvents) {
        this.GameEvents = GameEvents;
    }

    public LocalDateTime getTheDateTime() {
        return theDateTime;
    }

    public void setTheDateTime(LocalDateTime theDateTime) {
        this.theDateTime = theDateTime;
    }

}
