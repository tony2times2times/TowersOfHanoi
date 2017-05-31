//Tony Peraza
//20JUN17
//ICS 240-01 
//Test for Assignment 1 
//https://github.com/tony2times2times/multiGreeter

package edu.metrostate.ics240.p2.towers;

public class Towers {
	Ring[] pegOne, pegTwo, pegThree;

	public Towers(int n) {
		Ring[] pegOne = new Ring[n];
		Ring[] pegTwo = new Ring[n];
		Ring[] pegThree = new Ring[n];
		if (n <= 1 && n <= 64) {
			for (int i = 0; i < n; i++) {
				Ring ring = new Ring((i + 1));
				pegOne[i] = ring;
			}
		} else {
			// TODO exception here
		}
	}

	public Towers() {
		int defaultSize = 5;
		Ring[] pegOne = new Ring[defaultSize];
		Ring[] pegTwo = new Ring[defaultSize];
		Ring[] pegThree = new Ring[defaultSize];
		for (int i = 0; i < defaultSize; i++) {
			Ring ring = new Ring((i + 1));
			pegOne[i] = ring;
		}
	}

	// TODO add Javadoc
	public int getRingCount(int pegNumber) {
		Ring[] peg = getPeg(pegNumber);
		int ringCount = 0;
		for (Ring i : peg) {
			if (i != null) {
				ringCount++;
			}
		}
		return ringCount;
	}

	// TODO add Javadoc
	public int getTopDiameter(int pegNumber) {
		Ring[] peg = getPeg(pegNumber);
		int ringIndex = getRingCount(pegNumber);
		// If there are no rings on the peg return zero
		if (ringIndex == 0) {
			return 0;
		}
		// If there are rings on the peg return the diameter of the top ring.
		else {
			ringIndex--;
			return peg[ringIndex].getDiameter();
		}
	}

	public boolean move(int startPeg, int endPeg) {
		int movingRingDiameter = getTopDiameter(startPeg);
		int endRingDiameter = getTopDiameter(startPeg);
		//1 is subtracted because ring count returns the number of rings not the index. (i.e. if there is 1 ring 1 is returned not zero)
		int startPegIndex = getRingCount(startPeg) - 1;
		//In this case the ringCount is perfect because we will be placing a ring on top of the current top ring.
		int endPegIndex = getRingCount(endPeg);
		//Verify preconditions and if not met return false
		if (startPeg == endPeg
				|| startPeg < 1 
				|| startPeg > 3
				|| endPeg < 1 
				|| endPeg > 3 
				|| startPegIndex < 0
				|| movingRingDiameter < endRingDiameter) {
			return false;
		} else {
			Ring[] start = getPeg(startPeg);
			Ring[] end = getPeg(endPeg);
			//Create a new ring on the end peg identical to the ring being moved
			end[endPegIndex] = new Ring(start[startPegIndex]);
			//Remove the ring from the startPeg 
			start[startPegIndex] = null;
			return true;
		}
	}

	// TODO add Javadoc
	private Ring[] getPeg(int pegIndex) {
		if (pegIndex < 1 || pegIndex > 3) {
			throw new IllegalArgumentException(
					"Pegs are numbered 1 to 3. Peg: " + Integer.toString(pegIndex) + " does not exist.");
		}
		switch (pegIndex) {
		case 1:
			return pegOne;
		case 2:
			return pegTwo;
		default:
			return pegThree;
		}
	}
}