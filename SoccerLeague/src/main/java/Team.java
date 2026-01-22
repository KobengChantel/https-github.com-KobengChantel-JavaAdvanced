package soccerLeague;

public class Team implements Comparable<Team> {
    private String name;
    private int points;

    public Team(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addWin() {
        points += 3;
    }

    public void addDraw() {
        points += 1;
    }

    @Override
    public int compareTo(Team other) {
        // Sort by points descending
        int pointCompare = Integer.compare(other.points, this.points);

        if (pointCompare == 0) {
            // Alphabetical if equal points
            return this.name.compareTo(other.name);
        }
        return pointCompare;
    }

    @Override
    public String toString() {
        return name + " " + points;
    }
}
