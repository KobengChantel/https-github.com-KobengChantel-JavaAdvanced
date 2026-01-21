

package event;

import play.Player;
import play.Team;

//import soccer.event.soccer.play.Player;
//import chapter15.soccer.event.soccer.play.Team;


public abstract class GameEvent {

    private Team theTeam;
    private Player thePlayer;
    private double theTime;
    int ballPos;


    public GameEvent() {

        // Eventually only for Dribble?


    }

    /**
     * @return the theTeam
     */
    public Team getTheTeam() {
        return theTeam;
    }

    /**
     * @param theTeam the theTeam to set
     */
    public void setTheTeam(Team theTeam) {
        this.theTeam = theTeam;
    }

    /**
     * @return the thePlayer
     */
    public Player getThePlayer() {
        return thePlayer;
    }

    /**
     * @param thePlayer the thePlayer to set
     */
    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    /**
     * @return the theTime
     */
    public double getTheTime() {
        return theTime;
    }

    /**
     * @param theTime the theTime to set
     */
    public void setTheTime(double theTime) {
        this.theTime = theTime;
    }

    public abstract GameEvent[] getNextEvents();

    public abstract boolean changePlayer();

    public abstract boolean changeTeam();

    /**
     * @return the ballPos
     */
    public int getBallPos() {
        return ballPos;
    }

    /**
     * @param ballPos the ballPos to set
     */
    public void setBallPos(int ballPos) {
        this.ballPos = ballPos + (util.Settings.PITCH_LENGTH - ballPos) / 8;
    }


    public void reverseBallPos() {
        this.ballPos = util.Settings.PITCH_LENGTH - this.ballPos;
    }


}
