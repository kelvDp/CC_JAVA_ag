
package practice_10_1;

public class League {

    public static void main(String[] args) {

        League theLeague = new League();

        Team[] theTeams = theLeague.createTeams();
        Game[] theGames = theLeague.createGames(theTeams);

        // Game currGame = theGames[0];

        for (Game currGame : theGames) {

            currGame.playGame();

            System.out.println(currGame.getDescription());

        }

        theLeague.showBestTeam(theTeams);

    }

    public Team[] createTeams() {

        Player player1 = new Player("George Eliot");
        // player1.setPlayerName();
        Player player2 = new Player("Graham Greene");
        // player2.setPlayerName();
        Player player3 = new Player("Geoffrey Chaucer");
        // player3.setPlayerName();
        Player[] thePlayers = { player1, player2, player3 };

        Team team1 = new Team("The Greens", thePlayers);
        // team1.setTeamName("The Greens");
        // team1.setPlayerArray(thePlayers);

        // Create team2
        Team team2 = new Team();
        team2.setTeamName("The Reds");
        team2.setPlayerArray(new Player[3]);
        team2.getPlayerArray()[0] = new Player("Robert Service");
        // team2.getPlayerArray()[0].setPlayerName();
        team2.getPlayerArray()[1] = new Player("Robbie Burns");
        // team2.getPlayerArray()[1].setPlayerName();
        team2.getPlayerArray()[2] = new Player("Rafael Sabatini");
        // team2.getPlayerArray()[2].setPlayerName();

        Team[] theTeams = { team1, team2 };
        return theTeams;
    }

    public Game[] createGames(Team[] theTeams) {
        Game theGame = new Game(theTeams[0], theTeams[1]);
        // theGame.setHomeTeam(theTeams[0]);
        // theGame.setAwayTeam(theTeams[1]);

        Game theGame2 = new Game(theTeams[1], theTeams[0]);
        Game theGame3 = new Game(theTeams[0], theTeams[1]);
        Game theGame4 = new Game(theTeams[1], theTeams[0]);

        Game[] theGames = { theGame, theGame2, theGame3, theGame4 };
        return theGames;
    }

    public void showBestTeam(Team[] theTeam) {
        Team currBestTeam = theTeam[0];

        System.out.println("\nTeam Points: ");

        for (Team team: theTeam) {
            System.out.println(team.getTeamName() + ": " + team.getPointsTotal());
            currBestTeam = (team.getPointsTotal() > currBestTeam.getPointsTotal() ? team : currBestTeam);
        }

        System.out.println("\nThe winners of the league are: " + currBestTeam.getTeamName());
    }

}