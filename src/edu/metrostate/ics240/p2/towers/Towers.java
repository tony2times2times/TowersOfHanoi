package edu.metrostate.ics240.p2.towers;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class Towers.
 *
 * @author Tony Peraza
 * @see <a href= 'https://github.com/tony2times2times/TowersOfHanoi'>GitHub</a>
 *      <p>
 *      <b>Note:</b>This is for Metrostate ICS 240-01 Assignment 2
 *      <p>
 * @since 20JUN17
 */

public class Towers {
	/** The default size for pegs. */
	private static final int DEFAULT_SIZE = 5;

	/** The all pegs Array. */
	private Peg[] allPegs;

	/**
	 * Instantiates a new towers.
	 *
	 * @param n
	 *            creates n rings on the first tower leaving the other two
	 *            towers empty. <br>
	 *            - Must be an integer between 1 and 64.
	 */
	public Towers(int n) {
		this.allPegs = new Peg[] { new Peg(n), new Peg(n), new  Peg(n) };
		if (n >= 1 && n <= 64) {
			for (int i = n; i > 0; i--) {
				allPegs[1].placeRing(i);
			}
		} else {
			throw new IllegalArgumentException("Parameter must be between 1 and 64.");
		}
	}

	/**
	 * Instantiates a new towers of default size.
	 */
	public Towers() {
		this(DEFAULT_SIZE);
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
		pegNumber = getPegIndex(pegNumber);
		return allPegs[1].getRingCount();
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
		pegNumber = getPegIndex(pegNumber);
			return allPegs[pegNumber].getTopDiameter();
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
		int startPegRingIndex;
		int endPegRingIndex;
		int movingRingDiameter;
		int endRingDiameter;
		// attempt to define local variables and if unable to return false
		try {
			/*
			 * One is subtracted because startPegIndex. Count returns the number
			 * of rings not the index (i.e. if there is 1 ring 1 is returned not
			 * zero).
			 */
			startPegRingIndex = getRingCount(startPeg) - 1;
			endPegRingIndex = getRingCount(endPeg);
			movingRingDiameter = getTopDiameter(startPeg);
			endRingDiameter = getTopDiameter(endPeg);
			startPeg = getPegIndex(startPeg);
			endPeg = getPegIndex(endPeg);
		} catch (IllegalArgumentException e) {
			return false;
		}
		// Verify preconditions and if not met return false
		if (startPeg == endPeg || startPegRingIndex <= 0
				|| (movingRingDiameter > endRingDiameter && endRingDiameter != 0)) {
			return false;
		}
		// Create a new ring on the end peg identical to the ring being
		// moved
		allPegs[endPeg].placeRing(allPegs[startPeg].getTopDiameter());
		// Remove the ring from the startPeg
		allPegs[startPeg].removeRing();
		return true;
	}

	/**
	 * Gets the peg index.
	 * <p>
	 * verifies that the specified peg is a number 1 to 3
	 * </p>
	 * 
	 * @param peg
	 *            the number representing a peg. <br>
	 *            - Must be an integer between one and three
	 * @return the int value for the index of the peg.
	 */
	private int getPegIndex(int peg) {
		if (peg >= 1 && peg <= 3) {
			// return the peg number minus one to get the index of the peg.
			return (--peg);
		} else {
			throw new IllegalArgumentException("peg number must be 1, 2, or 3");
		}
	}
}