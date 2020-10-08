
package practice_13_3;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import practice_13_3.utility.PlayerDatabase;

public class League {

    public static void main(String[] args) {

        League theLeague = new League();

        Team[] theTeams = theLeague.createTeams("The Robins,The Crows,The Swallows", 5);
        Game[] theGames = theLeague.createGames(theTeams);

        System.out.println(theLeague.getLeagueAnnouncement(theGames));

        for (Game currGame : theGames) {
            currGame.playGame();
            System.out.println(currGame.getDescription());
        }

        theLeague.showBestTeam(theTeams);
        theLeague.showBestPlayer(theTeams);

    }

    public Team[] createTeams(String teamNames, int nrOfPlayers) {

        PlayerDatabase playerDB = new PlayerDatabase();
        StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ",");
        Team[] theTeams = new Team[teamNameTokens.countTokens()];

        for (int i = 0; i < theTeams.length; i++) {
            theTeams[i] = new Team(teamNameTokens.nextToken(), playerDB.getTeams(nrOfPlayers));
        }

        return theTeams;
    }

    public void showBestPlayer(Team[] theTeams) {

        ArrayList<Player> thePlayers = new ArrayList<>();
        for (Team currTeam : theTeams) {
            thePlayers.addAll(Arrays.asList(currTeam.getPlayerArray()));
        }

        Collections.sort(thePlayers,
                (p1, p2) -> Double.valueOf(p2.getGoalsScored()).compareTo(Double.valueOf(p1.getGoalsScored())));

        System.out.println("\n\nBest Players:");
        for (Player currPlayer : thePlayers) {
            System.out.println(currPlayer.getPlayerName() + ": " + currPlayer.getGoalsScored());
        }
    }

    public Game[] createGames(Team[] theTeams) {
        int daysBetweenGames = 0;
        ArrayList<Game> theGames = new ArrayList<>();

        for (Team homeTeam : theTeams) {
            for (Team awayTeam : theTeams) {
                if (homeTeam != awayTeam) {
                    daysBetweenGames += 7;
                    theGames.add(new Game(homeTeam, awayTeam, LocalDateTime.now().plusDays(daysBetweenGames)));
                }
            }
        }

        return (Game[]) theGames.toArray(new Game[1]);
    }

    public void showBestTeam(Team[] theTeams) {
        Arrays.sort(theTeams);
        Team currBestTeam = theTeams[0];
        System.out.println("\nTeam Points");

        for (Team currTeam : theTeams) {
            System.out.println(
                    currTeam.getTeamName() + " : " + currTeam.getPointsTotal() + " : " + currTeam.getGoalsTotal());
            // currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal() ?
            // currTeam : currBestTeam;

        }

        System.out.println("Winner of the League is " + currBestTeam.getTeamName());

    }

    public String getLeagueAnnouncement(Game[] theGames) {

        Period timePeriod = Period.between(theGames[0].getTheDateTime().toLocalDate(),
                theGames[theGames.length - 1].getTheDateTime().toLocalDate());

        return "\nThe league will run for " + timePeriod.getMonths() + " month(s), and " + timePeriod.getDays()
                + " day(s)\n";
    }

}
