package edu.oregonstate.cs361.battleship;

/**
 * Created by mcwhirtc on February 3rd, 2017.
 */
public class ComputerFire {

	// Computer AI, the BattleshipModel, Number of ships, and the ship array containing all the user ships
	private BattleshipModel cpuModel;
	private int numShips;
	private Ship[] allUserShips;

	// Constructor
	public ComputerFire (BattleshipModel cpuModel) {
		this.cpuModel = cpuModel;
		setAllUserShips();
	}

	// This function add all the User ships in the model to the Ship array
	public void setAllUserShips() {
		numShips = 5;
		allUserShips = new Ship [numShips];
		allUserShips[0] = cpuModel.getAircraftCarrier();
		allUserShips[1] = cpuModel.getBattleship();
		allUserShips[2] = cpuModel.getClipper();
		allUserShips[3] = cpuModel.getDinghy();
		allUserShips[4] = cpuModel.getSubmarine();
	}

	public BattleshipModel cpuFireBattleshipModel(ComputerAI ai) {
		Point targetCpuFired = ai.fire();
		for (int i = 0; i < numShips; i++) {
			if (Utility.targetHit(allUserShips[i].getStart(), allUserShips[i].getEnd(), targetCpuFired)) {
				//if((i == 2) || (i == 3)) {
				//	allUserShips[i].setHit(1);
				//	allUserShips[i].destroy(cpuModel);
				//}

				//else {
					cpuModel.addComputerHits(targetCpuFired);
				//}
				return cpuModel;
			}
		}
		cpuModel.addComputerMisses(targetCpuFired);
		return cpuModel;
	}
}
