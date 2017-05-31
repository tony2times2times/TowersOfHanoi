//Tony Peraza
//20JUN17
//ICS 240-01 
//Assignment 2 
//https://github.com/tony2times2times/TowersOfHanoi

//TODO test all functions
//TODO verify all outputs

package edu.metrostate.ics240.p2.towers;

public class Towers {
	private int[] pegOne, pegTwo, pegThree;
	private int[][] allPegs;

	public Towers(int n) {
		this.pegOne = new int[n];
		this.pegTwo = new int[n];
		this.pegThree = new int[n];
		if (n >= 1 && n <= 64) {
			for (int i = 0; i < n; i++) {
				// Initialize pegOne with n rings of increasing size starting
				// with a diameter of one.
				pegOne[i] = (i + 1);
			}
		} else {
			throw new IllegalArgumentException("Value must be between 1 and 64.");
		}
		this.allPegs = new int[][] { pegOne, pegTwo, pegThree };
	}

	public Towers() {
		int defaultSize = 5;
		this.pegOne = new int[defaultSize];
		this.pegTwo = new int[defaultSize];
		this.pegThree = new int[defaultSize];
		for (int i = 0; i < defaultSize; i++) {
			/*
			 * Initialize pegOne with n rings of increasing size starting with a
			 * diameter of one.
			 */
			pegOne[i] = (i + 1);
		}
		this.allPegs = new int[][] { pegOne, pegTwo, pegThree };
	}

	// TODO add Javadoc
	public int getRingCount(int pegNumber) {
		if (!verifyPeg(pegNumber) ) {
			throw new IllegalArgumentException("pegNumber must be a value between 1 and 3");
		} else {
			int ringCount = 0;
			//subtract one from pegNumber to get the index of all pegs
			pegNumber--;
			for (int i : allPegs[pegNumber]) {
				if (i != 0) {
					ringCount++;
				}
			}
			return ringCount;
		}
	}

	// TODO add Javadoc
	public int getTopDiameter(int pegNumber) {
		int ringIndex = getRingCount(pegNumber);
		// If there are no rings on the peg return zero.
		if (ringIndex == 0) {
			return 0;
		} else {
			// Subtract one from the count to get the index. if the count is 1
			// peg the index of that peg is zero
			ringIndex--;
			return allPegs[pegNumber][ringIndex];
		}

	}

	public boolean move(int startPeg, int endPeg) {
		int movingRingDiameter = getTopDiameter(startPeg);
		int endRingDiameter = getTopDiameter(startPeg);
		/*
		 * one is subtracted because ring count returns the number of rings not
		 * the index. (i.e. if there is 1 ring 1 is returned not zero)
		 */
		int startPegRingIndex = getRingCount(startPeg) - 1;
		// In this case the ringCount is perfect because we will be placing a
		// Destination index for the ring to be moved.
		int endPegRingIndex = getRingCount(endPeg);
		// Verify preconditions and if not met return false
		if (startPeg == endPeg || startPeg < 1 || startPeg > 3 || endPeg < 1 || endPeg > 3 || startPegRingIndex < 0
				|| movingRingDiameter > endRingDiameter) {
			return false;
		} else {
			// Create a new ring on the end peg identical to the ring being
			// moved
			allPegs[endPeg][endPegRingIndex] = allPegs[startPeg][startPegRingIndex];
			// Remove the ring from the startPeg
			allPegs[startPeg][startPegRingIndex] = 0;
			return true;
		}
	}

	private boolean verifyPeg(int peg) {
		if (peg >= 1 && peg <= 3) {
			return true;
		} else {
			return false;
		}
	}
}