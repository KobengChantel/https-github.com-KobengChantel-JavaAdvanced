import java.util.*;

public class League {

    /**
     * Processes a single match result and updates the points table.
     *
     * @param line  the match result in the format "TeamName score, TeamName score"
     * @param table the map storing teams and their accumulated points
     */
    private static void processMatch(String line, Map<String, Team> table) {
        // Split the input line by comma to separate the two teams
        String[] parts = line.split(",\\s*");

        // Extract team names and scores for both teams
        String[] t1 = splitTeamScore(parts[0]); // Team 1
        String[] t2 = splitTeamScore(parts[1]); // Team 2

        String team1Name = t1[0];
        int score1 = Integer.parseInt(t1[1]); // Convert string score to integer

        String team2Name = t2[0];
        int score2 = Integer.parseInt(t2[1]); // Convert string score to integer

        // Add teams to the table if they don't already exist
        table.putIfAbsent(team1Name, new Team(team1Name));
        table.putIfAbsent(team2Name, new Team(team2Name));

        // Retrieve Team objects from the table
        Team team1 = table.get(team1Name);
        Team team2 = table.get(team2Name);

        // Apply scoring rules:
        // Win = 3 points, Draw = 1 point, Loss = 0 points
        if (score1 > score2) {
            team1.addWin();        // Team 1 wins
        } else if (score2 > score1) {
            team2.addWin();        // Team 2 wins
        } else {
            team1.addDraw();       // Draw: both teams get 1 point
            team2.addDraw();
        }
    }

    /**
     * Splits a team-score string into the team name and score.
     * Handles multi-word team names by splitting at the last space.
     *
     * @param s the string in the format "TeamName score"
     * @return a String array: [0] = team name, [1] = score
     */
    private static String[] splitTeamScore(String s) {
        // Find the last space to separate the score from the team name
        int last = s.lastIndexOf(' ');
        String name = s.substring(0, last).trim();   // Team name
        String score = s.substring(last + 1).trim(); // Score
        return new String[]{name, score};
    }

    /**
     * Prints the final ranking table of teams.
     * Teams are sorted by points descending, and ties are sorted alphabetically.
     * Teams with the same points share the same rank number.
     *
     * @param table the map storing all teams
     */
    private static void printRanking(Map<String, Team> table) {
        // Convert the map values into a list for sorting
        List<Team> ranking = new ArrayList<>(table.values());
        Collections.sort(ranking); // Uses Team.compareTo (points desc, name asc)

        int rank = 1; // Current rank
        for (int i = 0; i < ranking.size(); i++) {
            // Update rank only if the current team has fewer points than previous
            if (i > 0 && ranking.get(i).getPoints() != ranking.get(i - 1).getPoints()) {
                rank = i + 1;
            }
            // Print rank, team name, and points
            System.out.println(rank + ". " + ranking.get(i));
        }
    }

    public static void main(String[] args) {
        // Sample match results as a list of strings
        List<String> input = Arrays.asList(
                "Liverpool 3, Manchester United 3",
                "Tarantulas2 1, FC Awesome 0",
                "Lions 1, FC Awesome 1",
                "Tarantulas2 3, Manchester United 1",
                "Lions 4, Grouches 0"
        );

        // Map to store teams and their points
        Map<String, Team> table = new HashMap<>();

        // Process each match and update points table
        for (String line : input) {
            processMatch(line, table);
        }

        // Print the final ranking table
        printRanking(table);
    }
}
