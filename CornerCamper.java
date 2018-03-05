package NR;
import robocode.*;
import java.awt.Color;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class CornerCamper extends Robot
{

	double wallDistance; // How far the wall is


	public void run() {

		// Initialize wallDistance to the maximum possible for this battlefield.
		wallDistance = Math.max(getBattleFieldWidth(), getBattleFieldHeight()); 
		
       //how fast the gun will turn
       int gunIncrement = 10;

		// turnLeft to face a wall.
		turnLeft(getHeading() % 90);
		ahead(wallDistance);
		
		// Turn the gun to turn right 90 degrees 

		turnGunRight(90);
		turnRight(90);

		while (true) {

       for(int i=0; i<5;i++)
	   {	
	   	for(int j=0; j<9;j++)	
		   turnGunLeft(gunIncrement);
		   
		for(int k=0; k<9; k++)
	    	turnGunRight(gunIncrement);
		}

			// Ride the Walls
			ahead(wallDistance);

			// Turn to the next wall
			turnRight(90);
		}
	}

	/**
	 * onHitRobot:  Move away a bit.
	 */
	public void onHitRobot(HitRobotEvent e) {
		// If he's in front of us, set back up a bit.
		if (e.getBearing() > -90 && e.getBearing() < 90) {
			back(100);
		} // else he's in back of us, so set ahead a bit.
		else {
			ahead(100);
		}
	}

	/**
	 * onScannedRobot:  Fire!
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		if(e.getDistance() < 100)
		   fire(Rules.MAX_BULLET_POWER);
		else
		   fire(1);
		
	}
}

