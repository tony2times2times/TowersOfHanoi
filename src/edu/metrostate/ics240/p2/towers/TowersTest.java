package edu.metrostate.ics240.p2.towers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TowersTest {

	@Test
	public void test() {
		// fail("Not yet implemented");
		Towers newGameNoInput = new Towers();
		Towers newGameSize64 = new Towers(64);
		Towers newGameSize1 = new Towers(1);

		try {
			Towers newGameSize65 = new Towers(65);
			fail();
		} catch (IllegalArgumentException e) {

		}
		try {
			Towers newGameSize0 = new Towers(0);
			fail();
		} catch (IllegalArgumentException e) {
		}
		if (newGameNoInput.getRingCount(1) != 5 
				|| newGameNoInput.getRingCount(2) != 0
				|| newGameNoInput.getRingCount(3) != 0) {
			fail("getRingCount failed");
		}
		try {
			newGameNoInput.getRingCount(4);
			fail();
		} catch (IllegalArgumentException e) {

		}
		try {
			newGameNoInput.getRingCount(0);
			fail();
		} catch (IllegalArgumentException e) {

		}
	}

}
