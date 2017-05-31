//Tony Peraza
//20JUN17
//ICS 240-01 
//Test for Assignment 1 
//https://github.com/tony2times2times/multiGreeter

package edu.metrostate.ics240.p2.towers;

public class Ring {
	private int diameter;
	
	public Ring(int diameter){
		this.diameter = diameter;
	}
	
	//Copy constructor
	public Ring(Ring ring){
		this.diameter = ring.getDiameter();
	}
	
	//TODO add Javadoc 
	public int getDiameter() {
		return diameter;
	}
	
	//TODO add Javadoc 
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
}
