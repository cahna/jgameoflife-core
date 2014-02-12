package com.cheine.jgameoflife.GameOfLifeTest;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import com.cheine.jgameoflife.GameOfLife;

public class MethodTest {
	
	// Using universe with block, blinker, and spaceship for tests
	private final int testTicks = 100;
	private final int knownWidth = 6;
	private final int knownHeight = 6;
	private final String[] knownUniverse = {
			// Step 1
			"000000\n" +
			"011000\n" +
			"010000\n" +
			"000010\n" +
			"000110\n" +
			"000000\n",
			
			// Step 2
			"000000\n" +
			"011000\n" +
			"011000\n" +
			"000110\n" +
			"000110\n" +
			"000000\n"
	};

	/**
	 * Ensures that a given serialized map of a Universe corresponds with a
	 * given 2D array of booleans (is alive statuses). This verifies my planned,
	 * specific implementation of serialize() since it is also tightly coupled 
	 * with these test implementations. 
	 * 
	 * @param map boolean statuses of organisms' current alive status
	 * @param serializedMap string to verify
	 * @return true if the true/false values in map correspond to '1'/'0' in 
	 * serializedMap, and if all rows are terminated by a '\n'. False otherwise
	 * and if serializedMap contains invalid or extra characters. 
	 */
	public static boolean serializedIntegrityCheck(boolean[][] map, String serializedMap) {
		int height = map.length; // How many columns 
		int width = map[0].length; // How many rows
		int cIndex = 0;
		
		for(int col = 0; col < height; col++) {
			for(int row = 0; row < width; row++) {
				char c;
				boolean expectedState;
				
				try {
					c = serializedMap.charAt(cIndex);
				} catch(IndexOutOfBoundsException e) {
					return false;
				}
				
				
				switch(c) {
					case '\n':
						// Newlines should only mark end of columns for my serialize() implementation
						return false;
					
					case '1': 
						expectedState = true;
						break;
					
					case '0': 
						expectedState = false;
						break;
					
					default: 
						// Invalid character in string
						return false;
				}
				
				// State mismatch
				if(expectedState != map[col][row])
					return false;
				
				cIndex++;
			}
			
			// Newlines should only mark end of columns for my serialize() implementation
			if(serializedMap.charAt(cIndex) != '\n')
				return false;
			else
				cIndex++;
		}
		
		try {
			// There should not be any more characters left in the stream after processing
			serializedMap.charAt(cIndex);
			return false;
		} catch(IndexOutOfBoundsException e) {
			// An exception is what is wanted
			return true;
		}		
	}
	
	/**
	 * Checks that all values in a boolean[][] map match the given requiredStatus value.
	 * 
	 * @param requiredStatus boolean to check all map values against
	 * @param map
	 * @return true if all values in map match requiredStatus; false otherwise.
	 */
	public static boolean containsUniformStatus(boolean requiredStatus, boolean[][] map) {
		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[0].length; x++) {
				if(map[y][x] != requiredStatus) {
					return false;
				} else {
					continue;
				}
			}
		}
		
		return true;
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.GameOfLife#tick()}.
	 * @throws ParseException 
	 */
	@Test
	public void testTick() throws ParseException {		
		GameOfLife testGame = new GameOfLife(knownUniverse[0]);
		int len = knownUniverse.length;
		
		for(int tick = 0; tick < len; tick++) {
			assertEquals(tick, testGame.elapsedTicks());
			
			String currentState = testGame.serialize();
			String expectedState = knownUniverse[tick]; 
			
			assertEquals(expectedState, currentState);
			
			testGame.tick();
		}
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.GameOfLife#getStatusMap()}.
	 * @throws ParseException 
	 */
	@Test
	public void testGetStatusMap() throws ParseException {
		GameOfLife testGame = new GameOfLife(knownUniverse[0]);
		boolean[][] map = testGame.getStatusMap();
		assertTrue(serializedIntegrityCheck(map, testGame.serialize()));
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.GameOfLife#getWidth()}.
	 * @throws ParseException 
	 */
	@Test
	public void testGetWidth() throws ParseException {
		GameOfLife testGame = new GameOfLife(knownUniverse[0]);
		assertEquals(knownWidth, testGame.getWidth());
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.GameOfLife#getHeight()}.
	 * @throws ParseException 
	 */
	@Test
	public void testGetHeight() throws ParseException {
		GameOfLife testGame = new GameOfLife(knownUniverse[0]);
		assertEquals(knownHeight, testGame.getHeight());
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.GameOfLife(String)}.
	 */
	@Test
	public void testGameOfLifeString() throws ParseException {
		GameOfLife testGame = new GameOfLife(knownUniverse[0]);
		int cycles = knownUniverse.length;
		
		for(int i = 0; i < cycles; i++) {
			testGame = new GameOfLife(knownUniverse[i]);
			assertEquals(knownWidth, testGame.getWidth());
			assertEquals(knownHeight, testGame.getHeight());
			assertEquals(knownUniverse[i], testGame.serialize());
			assertTrue(serializedIntegrityCheck(testGame.getStatusMap(), knownUniverse[i]));
		}
	}
	
	/**
	 * Test method for {@link com.cheine.jgameoflife.GameOfLife()}.
	 * @throws ParseException 
	 */
	@Test
	public void testGameOfLifeIntInt() throws ParseException {
		GameOfLife game = new GameOfLife(knownWidth, knownHeight);
		assertEquals(knownWidth, game.getWidth());
		assertEquals(knownHeight, game.getHeight());
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.GameOfLife#serialize()}
	 * using {@link com.cheine.jgameoflife.GameOfLife(String)} constructor.
	 * @throws ParseException 
	 */
	@Test
	public void testSerialize() throws ParseException {
		GameOfLife testGame = new GameOfLife(knownUniverse[0]);
		int cycles = knownUniverse.length;
		
		// Test all known universe statues with serialize
		for(int i = 0; i < cycles; i++){
			assertEquals(knownUniverse[i], testGame.serialize());
			testGame.tick();
		}
	}
	
	/**
	 * Test method for {@link com.cheine.jgameoflife.GameOfLife#serialize()}
	 * using {@link com.cheine.jgameoflife.GameOfLife(int, int)} constructor.
	 * @throws ParseException 
	 */
	@Test
	public void testSerializeWithBooleanMap() {
		GameOfLife testGame = new GameOfLife(13,7);
		assertTrue(serializedIntegrityCheck(testGame.getStatusMap(), testGame.serialize()));
	}
	
	/**
	 * Test method chaining output of {@link com.cheine.jgameoflife.GameOfLife#serialize()}
	 * into {@link com.cheine.jgameoflife.GameOfLife(String)} constructor.
	 * @throws ParseException 
	 */
	@Test
	public void testSerializeThenLoad() throws ParseException {
		GameOfLife testGame = new GameOfLife(5, 6);
		String serialized = testGame.serialize();
		GameOfLife duplicateGame = new GameOfLife(serialized);
		assertEquals(serialized, duplicateGame.serialize());
	}
}
