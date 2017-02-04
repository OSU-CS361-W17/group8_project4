package edu.oregonstate.cs361.battleship;

/**
 * Created by mcwhirtc on February 3rd, 2017.
 */
public class ComputerFire {
	//User Fire should run first.
	//Computer Fire:
    // shipMisses = GET (number of computer ship missed shots)
    // shipXFire = floor((shipMisses * 2) / 10)
    // shipYFire = (shipMisses * 2) % 10
    // POST("/ComputerFire/shipXFire/shipYFire)

	//public
	public int shipMisses = 0;			//GET (number of computer ship missed shots)

	//private
	private int shipXFire = 0;			//shipXFire = floor((shipMisses * 2) / 10)
	private int shipYFire = 0;			//shipYFire = (shipMisses * 2) % 10

	public /*Player Board Object Type*/ int chooseCoordinates() {
		//if(x)										//Previous shot missed.
			calculateMissedShotCoordinates();		//Calculate X,Y to fire at.
			return /*Fire[shipXFire][shipYFire]*/ 0;//Return fire location object.
		
		//else if(y)								//Previous shot hit!
			//NULL;									//Follow a tracking procedure.
		
		//else										//Previous shot was invalid?
			//NULL;									//Do nothing
	}
	
    private void calculateMissedShotCoordinates() {
		shipXFire = ((shipMisses * 2) / 10);	//Ex: floor(34*2/10) = 6
		shipYFire = (shipMisses * 2) % 10;			//Ex: 34*2%10 = 8
													//Coords to fire at: [6][8]
    }
}
