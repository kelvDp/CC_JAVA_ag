
package practice_14_1.utility;

import java.util.ArrayList;
import java.util.StringTokenizer;

import practice_14_1.Player;

public class PlayerDatabase {

    /* Practice 11-2. Declare an ArrayList here */
    private ArrayList<Player> players;

    /* Practice 11-2. Add Constructor here */
    public PlayerDatabase() {

        StringTokenizer authorTokens = new StringTokenizer(authorList, ",");
        players = new ArrayList<>();

        while (authorTokens.hasMoreTokens()) {
            players.add(new Player(authorTokens.nextToken()));
        }
    }

    /* Practice 11-2. Add getTeam() method here */
    public Player[] getTeams(int numOfPlayers) throws PlayerDbException{

        Player[] teamPlayers = new Player[numOfPlayers];

        for (int i = 0; i < numOfPlayers; i++) {
            int randomIndex = (int) (Math.random() * players.size());
            try {
                teamPlayers[i] = players.get(randomIndex);
                players.remove(randomIndex);
            } catch(IndexOutOfBoundsException ie) {
                throw new PlayerDbException("Not enough players in the database for teams requested.");
            }
        }

        return teamPlayers;
    }

    String authorList = "Agatha Christie," + "Alan Patton," + "Alexander Solzhenitsyn," + "Arthur Conan Doyle,"
            + "Anthony Trollope," + "Baroness Orczy," + "Brendan Behan," + "Brian Moore," + "Boris Pasternik,"
            + "Charles Dickens," + "Charlotte Bronte," + "Dorothy Parker," + "Emile Zola," + "Frank O'Connor,"
            + "Geoffrey Chaucer," + "George Eliot," + "G. K. Chesterton," + "Graham Green," + "Henry James,"
            + "James Joyce," + "J. M. Synge," + "J. R. Tolkien," + "Jane Austin," + "Leo Tolstoy," + "Liam O'Flaherty,"
            + "Marcel Proust," + "Mark Twain," + "Oscar Wilde," + "O. Henry," + "Samuel Beckett," + "Sean O'Casey,"
            + "William Shakespeare," + "William Makepeace Thackeray," + "W. B. Yeats," + "Wilkie Collins";

}