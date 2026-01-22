/**
 * Represents a soccer team in the league.
 * Stores the team name and its accumulated points.
 * Implements Comparable to allow sorting by points (descending) and
 * alphabetical order for ties.
 */
public class Team implements Comparable<Team> {

    // The name of the team (cannot be changed after creation)
    private final String name;

    // The total points the team has earned in the league
    private int points;

    /**
     * Constructor to create a new team with the given name.
     * Initially, the team has 0 points.
     *
     * @param name the name of the team
     */
    public Team(String name) {
        this.name = name;
        this.points = 0; // starts with 0 points
    }

    /**
     * Adds 3 points to the team for a win.
     */
    public void addWin() {
        points += 3;
    }

    /**
     * Adds 1 point to the team for a draw.
     */
    public void addDraw() {
        points += 1;
    }

    /**
     * Returns the current points of the team.
     *
     * @return total points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Returns the name of the team.
     *
     * @return team name
     */
    public String getName() {
        return name;
    }

    /**
     * Compares this team with another team for sorting.
     * Primary sort: points in descending order.
     * Secondary sort (tie-breaker): alphabetical order (case-insensitive).
     *
     * @param other the other team to compare against
     * @return negative if this team should come before, positive if after, 0 if equal
     */
    @Override
    public int compareTo(Team other) {
        // Compare points descending
        int diff = Integer.compare(other.points, this.points);
        if (diff != 0) return diff;

        // If points are equal, compare names alphabetically
        return this.name.compareToIgnoreCase(other.name);
    }

    /**
     * Returns a string representation of the team,
     * including its name and current points.
     *
     * @return formatted string "TeamName points"
     */
    @Override
    public String toString() {
        return name + " " + points;
    }
}
