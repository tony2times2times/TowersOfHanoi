package edu.metrostate.ics240.p2.towers;

/**
 * The Class Towers.
 * 
 * @author Tony Peraza
 * @since 20JUN17
 * @see <a href= 'https://github.com/tony2times2times/TowersOfHanoi'>GitHub</a>
 *      <p>
 *      <b>Note:</b>This is for Metrostate ICS 240-01 Assignment 2
 *      <p>
 */

public class Towers {

	/** The peg three. */
	private int[] pegOne, pegTwo, pegThree;

	/** The all pegs. */
	private int[][] allPegs;

	/**
	 * Instantiates a new towers.
	 *
	 * @param n
	 *            creates n rings on the first tower leaving the other two
	 *            towers empty. <br>
	 *            - Must be an integer between 1 and 64.
	 */
	public Towers(int n) {
		this.pegOne = new int[n];
		this.pegTwo = new int[n];
		this.pegThree = new int[n];
		if (n >= 1 && n <= 64) {
			int i = 0;
			for (int j = n; j > 0; j--) {
				// Initialize pegOne with n rings of increasing size starting
				// with a diameter of one.
				pegOne[i] = (j);
				i++;
			}
		} else {
			throw new IllegalArgumentException("Parameter must be between 1 and 64.");
		}
		this.allPegs = new int[][] { pegOne, pegTwo, pegThree };
	}

	/**
	 * Instantiates a new towers of default size.
	 */
	public Towers() {
		int defaultSize = 5;
		this.pegOne = new int [defaultSize];
		this.pegTwo = new int [defaultSize];
		this.pegThree = new int [defaultSize];
		int i = 0;
		for (int j = defaultSize; j > 0; j--) {
			/*
			 * Initialize pegOne with n rings of increasing size starting with a
			 * diameter of one.
			 */
			pegOne[i] = (j);
			i++;
		}
		this.allPegs = new int[][] { pegOne, pegTwo, pegThree };
	}

	/**
	 * Gets the ring count.
	 *
	 * @param pegNumber
	 *            the number representing a peg. <br>
	 *            - Must be an integer between one and three.
	 * @return the number of rings on the specified peg.
	 */
	// TODO add Javadoc
	public int getRingCount(int pegNumber) {
		if (!verifyPeg(pegNumber)) {
			throw new IllegalArgumentException("pegNumber must be 1, 2, or 3");
		} else {
			int ringCount = 0;
			// subtract one from pegNumber to get the index of all pegs
			pegNumber--;
			for (int i : allPegs[pegNumber]) {
				if (i != 0) {
					ringCount++;
				}
			}
			return ringCount;
		}
	}

	/**
	 * Gets the top diameter.
	 *
	 * @param pegNumber
	 *            the number representing a peg. <br>
	 *            - Must be an integer between one and three.
	 * @return If getRingCount(pegNumber) > 0, then the return value is the
	 *         diameter <br>
	 *         of the top ring on the specified peg; otherwise, the return value
	 *         is zero.
	 */
	public int getTopDiameter(int pegNumber) {
		int ringIndex = getRingCount(pegNumber);
		// If there are no rings on the peg return zero.
		if (ringIndex == 0) {
			return 0;
		} else {
			// Subtract one from the count to get the index. if the count is 1
			// peg the index of that peg is zero
			ringIndex--;
			// Subtract one from the pegNumber because allPegs also indexes at
			// zero
			pegNumber--;
			return allPegs[pegNumber][ringIndex];
		}
	}

	/**
	 * Move.
	 * <p>
	 * Moves a ring from the startPeg to the endPeg.
	 * </p>
	 * 
	 * @param startPeg
	 *            the source of the ring to be moved. <br>
	 *            - Must not be the same value as endPeg.<br>
	 *            - Must be a peg with at least one ring.<br>
	 *            - Must be an integer between one and three.<br>
	 * @param endPeg
	 *            the destination peg. <br>
	 *            - Must not be the same value as startPeg. <br>
	 *            - Must be an integer between one and three<br>
	 * @return true, if successful. <br>
	 *         false, if not successful.
	 */
	public boolean move(int startPeg, int endPeg) {
		// Verify preconditions and if not met return false
		if (startPeg == endPeg || !verifyPeg(startPeg) || !verifyPeg(endPeg)) {
			return false;
		}
		/*
		 * One is subtracted because startPegIndex. Count returns the number of rings not
		 * the index (i.e. if there is 1 ring 1 is returned not zero).
		 */
		int startPegRingIndex = getRingCount(startPeg) - 1;
		int endPegRingIndex = getRingCount(endPeg);
		if (startPegRingIndex <= 0) {
			return false;
		}
		int movingRingDiameter = getTopDiameter(startPeg);
		int endRingDiameter = getTopDiameter(endPeg);
		if (movingRingDiameter < endRingDiameter || endRingDiameter == 0) {
			// Subtract one from startPeg and endPeg to get the index.
			startPeg--;
			endPeg--;
			// Create a new ring on the end peg identical to the ring being
			// moved
			allPegs[endPeg][endPegRingIndex] = allPegs[startPeg][startPegRingIndex];
			// Remove the ring from the startPeg
			allPegs[startPeg][startPegRingIndex] = 0;
			return true;	
		}else{
			return false;
		}
	}

	/**
	 * Verify peg.
	 * <p>
	 * verifies that the specified peg is a number 1 to 3
	 * </p>
	 * 
	 * @param peg
	 *            the number representing a peg. <br>
	 *            - Must be an integer between one and three
	 * @return true, if successful. <br>
	 *         false, if not successful.
	 */
	private boolean verifyPeg(int peg) {
		if (peg >= 1 && peg <= 3) {
			return true;
		} else {
			return false;
		}
	}
}