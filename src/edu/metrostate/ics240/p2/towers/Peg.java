package edu.metrostate.ics240.p2.towers;

/**
 * The Class Peg.
 */
public class Peg {

	/** The stick. */
	public int[] stick;
	
	/**
	 * Instantiates a new peg.
	 *
	 * @param pegSize the peg size
	 */
	Peg(int pegSize){
		this.stick = new int[pegSize];
	}
	
/**
 * Place ring.
 *
 * @param ringSize the ring size
 */
public void placeRing (int ringSize){
	int ringIndex = getRingCount();
	stick[ringIndex] = ringSize;
}

/**
 * Removes the ring.
 */
public void removeRing (){
	//subtract one from the count to get the index of the ring to be removed
	int ringIndex = getRingCount() -1;
	stick[ringIndex] = 0;
}
	
	/**
	 * Gets the ring count.
	 *
	 * @return the ring count
	 */
	public int getRingCount() {
		int ringCount = 0;
		for (int i = 0; i < stick.length; i++) {
			if (stick[i] != 0) {
				ringCount++;
			}
		}
		return ringCount;
	}
	
	/**
	 * Gets the top diameter.
	 *
	 * @return If getRingCount(pegNumber) > 0, then the return value is the
	 *         diameter <br>
	 *         of the top ring on the specified peg; otherwise, the return value
	 *         is zero.
	 */
	public int getTopDiameter(){
		int index = getRingCount()-1;
		if (index == -1) {
			return 0;
		}
		return stick[index];
	}
}
