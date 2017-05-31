package edu.metrostate.ics240.p2.towers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TowersTest {

	@Test
	public void test() {
		// Towers() test
		Towers gameNoInput = new Towers();

		// Towers(n) test
		Towers gameSize64 = new Towers(64);
		Towers newGameSize1 = new Towers(1);

		try {
			Towers gameSize65 = new Towers(65);
			fail("Towers(n) failed");
		} catch (IllegalArgumentException e) {

		}
		try {
			Towers gameSize0 = new Towers(0);
			fail("Towers(n) failed");
		} catch (IllegalArgumentException e) {
		}

		// getRingCount(int pegNumber) test
		if (gameNoInput.getRingCount(1) != 5 || gameNoInput.getRingCount(2) != 0 || gameNoInput.getRingCount(3) != 0) {
			fail("getRingCount(int pegNumber) failed");
		}
		try {
			gameNoInput.getRingCount(4);
			fail("getRingCount(int pegNumber) failed");
		} catch (IllegalArgumentException e) {

		}
		try {
			gameNoInput.getRingCount(0);
			fail("getRingCount(int pegNumber) failed");
		} catch (IllegalArgumentException e) {

		}

		// getTopDiameter (int pegNumber) test
		if (gameSize64.getTopDiameter(1) != 64 || gameNoInput.getTopDiameter(1) != 5) {
			fail("getRingCount(int pegNumber) failed");
		}

		// move(int startPeg, int endPeg) test
		if (gameSize64.move(1, 1)){
			fail("move(int startPeg, int endPeg) startPeg must not be the same value as endPeg.");
		}
		if (gameSize64.move(2, 1)){
			fail("move(int startPeg, int endPeg) startPeg must be a peg with at least one ring.");
		}
		if (gameSize64.move(0, 1)){
			fail("move(int startPeg, int endPeg) startPeg must be an integer between one and three.");
		}
		
		if (!gameSize64.move(1, 2)) {
			fail("move(int startPeg, int endPeg)  failed");
		}
		gameSize64.move(1, 3);
		if (gameSize64.move(2, 3)) {
		 fail("move(int startPeg, int endPeg) failed");
		 }
		 if(gameSize64.getTopDiameter(1) != 62){
		 fail("move(int startPeg, int endPeg) is not removing a ring from startPeg");
		 }
	}
}
