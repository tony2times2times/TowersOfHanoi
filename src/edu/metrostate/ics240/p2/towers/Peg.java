package edu.metrostate.ics240.p2.towers;

import java.util.Arrays;

public class Peg {
	private int[] stick;
	
	Peg(int pegSize){
		this.stick = new int[pegSize];
	}
	
public void placeRing (int ringSize){
	int ringIndex = getRingCount();
	stick[ringIndex] = ringSize;
}

public void removeRing (){
	//subtract one from the count to get the index
	int ringIndex = getRingCount();
	stick[ringIndex] = 0;
}
	
	public int getRingCount() {
		System.out.println(Arrays.toString(stick));
		int ringCount = 0;
		for (int i = 0; i < stick.length; i++) {
			if (stick[i] != 0) {
				ringCount++;
			}
		}
		return ringCount;
	}
	
	public int getTopDiameter(){
		int index = getRingCount()-1;
		if (index == -1) {
			return 0;
		}
		return stick[index];
	}
	
	
}
