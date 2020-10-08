package practice_8_1;

public class League {

    public static void main(String[] args) {

        // calling methods for createGame etc.
        Team[] theTeams = createTeams();
        Game[] theGames = createGames(theTeams);
        Game currGame = theGames[0];

        // creating a goal object
        Goal firstGoal = new Goal();
        firstGoal.thePlayer = currGame.homeTeam.playerArray[2];
        firstGoal.theTeam = currGame.homeTeam;
        firstGoal.theTime = 15;

        // goal array
        Goal[] theGoals = { firstGoal };
        currGame.goals = theGoals;

        // printing out score of the game
        System.out.println("The first goal was scored by " + currGame.goals[0].thePlayer.playerName + " from "
                + currGame.goals[0].theTeam.teamName + ", after " + currGame.goals[0].theTime + " minutes.");

        // finding player in team 2
        for (Player p : currGame.awayTeam.playerArray) {
            // System.out.println(p.playerName);
            if (p.playerName.matches(".*Sab.*")) {
                System.out.println("\nFound the player you're looking for: " + p.playerName);
                String lastName = p.playerName.split(" ")[1];
                System.out.println("His last name is " + lastName);
            }
        }

        // looping through team 1 and displaying last name first
        // StringBuilder lNames = new StringBuilder();

        for (Player p : currGame.awayTeam.playerArray) {
            String[] fullName = p.playerName.split(" ");
            // lNames.append(fullName[1]);
            // lNames.append(", ");
            // lNames.append(fullName[0]);
            // System.out.println(lNames);
            // lNames.delete(0, lNames.length());
            System.out.println(fullName[1] + ", " + fullName[0]);
        }
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

        Team[] theTeams = {team1, team2};
        return theTeams;
    }

    public static Game[] createGames(Team[] teams) {

        // creating a new game.
        Game theGame = new Game();
        theGame.homeTeam = teams[1];
        theGame.awayTeam = teams[0];
        Game[] theGames = {theGame};
        return theGames;
    }
}
