package soccerLeague;

import java.io.*;
import java.util.*;

public class SoccerLeague {

    public static void main(String[] args) {
        Map<String, Team> league = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("matches.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] match = line.split(",");

                // Process team 1
                String[] team1 = match[0].trim().split(" ");
                String name1 = String.join(" ", Arrays.copyOf(team1, team1.length - 1));
                int score1 = Integer.parseInt(team1[team1.length - 1]);

                // Process team 2
                String[] team2 = match[1].trim().split(" ");
                String name2 = String.join(" ", Arrays.copyOf(team2, team2.length - 1));
                int score2 = Integer.parseInt(team2[team2.length - 1]);

                league.putIfAbsent(name1, new Team(name1));
                league.putIfAbsent(name2, new Team(name2));

                if (score1 > score2) {
                    league.get(name1).addWin();
                } else if (score2 > score1) {
                    league.get(name2).addWin();
                } else {
                    league.get(name1).addDraw();
                    league.get(name2).addDraw();
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading matches.txt: " + e.getMessage());
        }

        List<Team> standings = new ArrayList<>(league.values());
        Collections.sort(standings);

        int rank = 1;
        int prevPoints = -1;
        int displayRank = 1;

        for (Team t : standings) {
            if (t.getPoints() != prevPoints) {
                displayRank = rank;
            }
            System.out.println(displayRank + ". " + t);
            prevPoints = t.getPoints();
            rank++;
        }
    }
}
