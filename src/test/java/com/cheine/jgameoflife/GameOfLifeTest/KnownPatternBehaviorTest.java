package com.cheine.jgameoflife.GameOfLifeTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.cheine.jgameoflife.GameOfLife;

@RunWith(Parameterized.class)
public class KnownPatternBehaviorTest {

	private final int TEST_GENERATIONS = 100;
	private String[] knownGenerations;

	public KnownPatternBehaviorTest(String[] knownGenerations) {
		this.knownGenerations = knownGenerations;
	}

	/**
	 * Generates test cases. 
	 * @return An array of test cases where each test case is an array defining
	 * known/expected sub-generations. 
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
				{ 
					// Block
					new Object[] { 
						"0000\n" +
						"0110\n" +
						"0110\n" +
						"0000\n"
					} 
				},
				{ 
					// Beehive
					new Object[] { 
						"000000\n" +
						"001100\n" +
						"010010\n" +
						"001100\n" +
						"000000\n"
					} 
				},
				{
					// Loaf
					new Object[] {
						"000000\n" +
						"001100\n" +
						"010010\n" +
						"001010\n" +
						"000100\n" +
						"000000\n"
					}
				},
				{ 
					// Boat
					new Object[] { 
						"00000\n" +
						"01100\n" +
						"01010\n" +
						"00100\n" +
						"00000\n"
					} 
				},
				{ 
					// Blinker (period 2)
					new Object[] {
						// Step 1
						"00000\n" +
						"00100\n" +
						"00100\n" +
						"00100\n" +
						"00000\n",
						
						// Step 2
						"00000\n" +
						"00000\n" +
						"01110\n" +
						"00000\n" +
						"00000\n"						
					} 
				},
				{ 
					// Toad (period 2)
					new Object[] {
						// Step 1
						"000000\n" +
						"000000\n" +
						"001110\n" +
						"011100\n" +
						"000000\n" +
						"000000\n",
						
						// Step 2
						"000000\n" +
						"000100\n" +
						"010010\n" +
						"010010\n" +
						"001000\n" +
						"000000\n"						
					} 
				},
				{ 
					// Blinker (period 2)
					new Object[] {
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
					} 
				}
			};
		
		return Arrays.asList(data);
	}
	
	/**
	 * This test relies on the serialize method to be properly implemented.
	 * I should add more tests that inspect universe states directly, but for the
	 * sake of saving time, I'm only leaving this test.
	 */
	@Test
	public void testPredestination() {
		GameOfLife testGame = new GameOfLife();
		int gen = 0;
		
		// Start the game
		testGame.load(knownGenerations[gen]); 
		
		for(int i = 0; i < TEST_GENERATIONS; i++) {
			gen = ++gen % knownGenerations.length; // Handle oscillators of any period length
			testGame.tick();
			assertEquals(knownGenerations[gen], testGame.serialize());
		}
	}
}

