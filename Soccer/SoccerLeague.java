import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//The SoccerLeague Java program reads soccer match results from a file, processes the scores,
// and calculates league rankings based on points. Each team earns 3 points for a win, 1 point for a draw,
// and 0 points for a loss. Teams and their scores are stored in a HashMap, allowing the program to quickly
// look up or add points for each team. Once all matches are processed, teams are sorted by points in descending order,
// with alphabetical ordering used to break ties. Finally, the program outputs the
// ranked leaderboard and includes error handling for improperly formatted data

public class SoccerLeague {

    // Inner class to represent a team with a name and points
    static class Team {
        String name;
        int points;

        // Constructor initializes the team with a name and 0 points
        public Team(String name) {
            this.name = name;
            this.points = 0;
        }

        // Method to add points to the team
        public void addPoints(int points) {
            this.points += points;
        }
    }

    public static void main(String[] args) {
        String filename = "matches.txt";  // File containing the game results
        Map<String, Team> teams = new HashMap<>();  // Map to store each team and its points

        // Reading match results from the file
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Process each line in the file as a match result
            while ((line = br.readLine()) != null) {
                processMatch(line, teams);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Sorting teams by points in descending order, then alphabetically if points are tied
        List<Team> sortedTeams = new ArrayList<>(teams.values());
        sortedTeams.sort((t1, t2) -> {
            // If points are the same, sort alphabetically
            if (t2.points == t1.points) {
                return t1.name.compareTo(t2.name);
            }
            // Otherwise, sort by points in descending order
            return Integer.compare(t2.points, t1.points);
        });

        // Printing the leaderboard with rankings
        int rank = 1;
        for (int i = 0; i < sortedTeams.size(); i++) {
            Team team = sortedTeams.get(i);
            // Update rank if the points are different from the previous team
            if (i > 0 && team.points != sortedTeams.get(i - 1).points) {
                rank = i + 1;
            }
            // Print the rank, team name, and points
            System.out.println(rank + ". " + team.name + " " + team.points);
        }
    }

    // Method to process a match line, update team points, and add teams if they don't exist
    private static void processMatch(String match, Map<String, Team> teams) {
        // Check if the line is correctly formatted and has both teams
        if (match == null || match.trim().isEmpty() || !match.contains(",")) {
            System.out.println("Invalid match format: " + match);
            return;
        }

        // Splitting teams and scores
        String[] parts = match.split(",");
        if (parts.length < 2) {
            System.out.println("Invalid match format: " + match);
            return;
        }

        String[] team1Data = parts[0].trim().split(" ");
        String[] team2Data = parts[1].trim().split(" ");

        // Ensure team data contains at least one word for name and one for score
        if (team1Data.length < 2 || team2Data.length < 2) {
            System.out.println("Invalid team data format: " + match);
            return;
        }

        // Extracting team names and scores
        String team1Name = String.join(" ", Arrays.copyOf(team1Data, team1Data.length - 1));
        int team1Score;
        try {
            team1Score = Integer.parseInt(team1Data[team1Data.length - 1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid score format for team1 in match: " + match);
            return;
        }

        String team2Name = String.join(" ", Arrays.copyOf(team2Data, team2Data.length - 1));
        int team2Score;
        try {
            team2Score = Integer.parseInt(team2Data[team2Data.length - 1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid score format for team2 in match: " + match);
            return;
        }

        // Ensure teams exist in the map
        teams.putIfAbsent(team1Name, new Team(team1Name));
        teams.putIfAbsent(team2Name, new Team(team2Name));

        // Determine points for each team based on match result
        if (team1Score > team2Score) {
            teams.get(team1Name).addPoints(3);  // Team 1 wins
        } else if (team1Score < team2Score) {
            teams.get(team2Name).addPoints(3);  // Team 2 wins
        } else {
            teams.get(team1Name).addPoints(1);  // Draw
            teams.get(team2Name).addPoints(1);  // Draw
        }
    }
}
