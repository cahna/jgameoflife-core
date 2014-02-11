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
		int width = 3, height = 3;
		String overpopulatedTest = "111\n111\n111\n";
		String afterClear = "000\n000\n000\n";
		
		testGame.load(overpopulatedTest);
		
		boolean[][] map = testGame.getStatusMap();
		
		// Make sure all organisms are alive
		assertEquals(overpopulatedTest, testGame.serialize());
				
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				assertTrue(map[i][j]);
			}
		}
		
		testGame.clear();
		
		// Make sure all organisms are dead
		
		assertEquals(afterClear, testGame.serialize());
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				assertFalse(map[i][j]);
			}
		}
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
		int width = 5, height = 5;
		testGame.populate(width, height);
		assertEquals(width, testGame.getWidth());
		assertEquals(height, testGame.getHeight());
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
