package com.cheine.jgameoflife.GameOfLifeTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cheine.jgameoflife.GameOfLife;

public class MethodTest {
	private GameOfLife testGame;
	
	@Before
	public void setUp() throws Exception {
		testGame = new GameOfLife();
	}

	@After
	public void tearDown() throws Exception {
		testGame = null;
	}

	@Test
	public void testTick() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStatusMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testClear() {
		testGame.populate();
	}

	@Test
	public void testGetWidth() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testPopulate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSerialize() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testLoad() {
		fail("Not yet implemented");
	}
}
