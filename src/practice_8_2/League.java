package practice_8_2;

// import practice_8_2.utility.GameUtils;

public class League {

    public static void main(String[] args) {

        // calling methods for createGame etc.
        Team[] theTeams = createTeams();
        Game[] theGames = createGames(theTeams);
        Game currGame = theGames[0];

        // playgame method
        currGame.playGame();


        // // printing out score of the game
        // System.out.println("The first goal was scored by " +
        // currGame.goals[0].thePlayer.playerName + " from "
        // + currGame.goals[0].theTeam.teamName + ", after " + currGame.goals[0].theTime
        // + " minutes.");

        System.out.println(currGame.getDesc());

    }

    // createTeams method
    public static Team[] createTeams() {

        // team 1
        Player player1 = new Player();
        player1.playerName = "George Eliot";
        Player player2 = new Player();
        player2.playerName = "Graham Greene";
        Player player3 = new Player();
        player3.playerName = "Geoffrey Chaucer";

        Player[] thePlayers = { player1, player2, player3 };
        Team team1 = new Team();
        team1.teamName = "The Greens";
        team1.playerArray = thePlayers;

        // team 2 -- different way
        Team team2 = new Team();
        team2.teamName = "The Reds";
        team2.playerArray = new Player[3];
        team2.playerArray[0] = new Player();
        team2.playerArray[0].playerName = "Robert Service";
        team2.playerArray[1] = new Player();
        team2.playerArray[1].playerName = "Robbie Burns";
        team2.playerArray[2] = new Player();
        team2.playerArray[2].playerName = "Rafael Sabatini";

        Team[] theTeams = { team1, team2 };
        return theTeams;
    }

    public static Game[] createGames(Team[] teams) {

        // creating a new game.
        Game theGame = new Game();
        theGame.homeTeam = teams[1];
        theGame.awayTeam = teams[0];
        Game[] theGames = { theGame };
        return theGames;
    }
}
