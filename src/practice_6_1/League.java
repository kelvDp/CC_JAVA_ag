package practice_6_1;

public class League {
    
    public static void main(String[] args) {
        
        // team 1
        Player player1 = new Player();
        player1.playerName = "George Eliot";
        Player player2 = new Player();
        player2.playerName = "Graham Greene";
        Player player3 = new Player();
        player3.playerName = "Geoffrey Chaucer";

        Player[] thePlayers = {player1, player2, player3};
        Team team1 = new Team();
        team1.teamName = "The Greens";
        team1.playerArray = thePlayers;

        // printing out player names for team1
        System.out.println("The Greens: ");
        for (Player name : team1.playerArray) {
            System.out.println(name.playerName);
        }

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

        // printing out player names for team 2
        System.out.println("\nThe Reds: ");
        for (Player name: team2.playerArray) {
            System.out.println(name.playerName);
        }
    }
}
