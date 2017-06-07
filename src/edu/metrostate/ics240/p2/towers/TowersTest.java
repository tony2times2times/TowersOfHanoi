package edu.metrostate.ics240.p2.towers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TowersTest {

	@Test
	public void test() {
		constructorTest();
		getRingCountTest();
		getTopDiameterTest();
		moveTest();
	}

	@SuppressWarnings("unused")
	private void constructorTest() {
		Towers gameNoInput = new Towers();
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
	}

	private void getRingCountTest() {
		Towers gameNoInput = new Towers();
		Towers gameSize64 = new Towers(64);
		assertEquals(gameNoInput.getRingCount(1), 5);
		assertEquals(gameNoInput.getRingCount(2), 0);
		assertEquals(gameNoInput.getRingCount(3), 0);
		assertEquals(gameSize64.getRingCount(1), 64);
		assertEquals(gameSize64.getRingCount(2), 0);
		assertEquals(gameSize64.getRingCount(3), 0);
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
	}

	private void getTopDiameterTest() {
		Towers gameNoInput = new Towers();
		Towers gameSize64 = new Towers(64);
		assertEquals(gameSize64.getTopDiameter(1), 1);
		assertEquals(gameNoInput.getTopDiameter(1), 1);
	}

	private void moveTest() {
		Towers gameSize64 = new Towers(64);
		assertFalse(gameSize64.move(1, 1));
		assertFalse(gameSize64.move(2, 1));
		assertFalse(gameSize64.move(0, 1));
		assertFalse(gameSize64.move(1, 4));
		assertTrue(gameSize64.move(1, 2));
		assertEquals(gameSize64.getTopDiameter(2), 1);
		assertTrue(gameSize64.move(1, 3));
		assertEquals(gameSize64.getTopDiameter(3), 2);
		assertFalse(gameSize64.move(3, 2));
		assertTrue(gameSize64.move(2, 3));
		assertEquals(gameSize64.getTopDiameter(1), 3);
	}
}
