package com.cheine.jgameoflife.GameOfLifeTest;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.cheine.jgameoflife.GameOfLife;

@RunWith(Parameterized.class)
public class KnownBehaviorTest {

	protected final int TEST_GENERATIONS = 100;
	protected String[] knownGenerations;

	public KnownBehaviorTest(String[] knownGenerations) {
		this.knownGenerations = knownGenerations;
	}

	/**
	 * Generates test cases. This class's data() is for static (period 1) 
	 * patterns. Override this in a subclass to provide different testing 
	 * parameters (including other oscillating patterns with longer periods)
	 *  
	 * @return An array of test cases where each test case is an array defining
	 * serialized forms of known/expected sub-generations. 
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
				{ 
					new String[] {// Block
					"0000\n" +
					"0110\n" +
					"0110\n" +
					"0000\n"} 
				},
				{ 
					new String[] {// Beehive	 
					"000000\n" +
					"001100\n" +
					"010010\n" +
					"001100\n" +
					"000000\n"}
					 
				},
				{
					new String[] {// Loaf
					"000000\n" +
					"001100\n" +
					"010010\n" +
					"001010\n" +
					"000100\n" +
					"000000\n"}
				},
				{ 
					new String[] {// Boat 
					"00000\n" +
					"01100\n" +
					"01010\n" +
					"00100\n" +
					"00000\n"}
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
	public void testPredestination() throws ParseException {
		int gen = 0, len = knownGenerations.length;
		int testLifetime = len * TEST_GENERATIONS;
		
		// Start the game
		GameOfLife testGame = new GameOfLife(knownGenerations[gen]);
		
		for(int i = 0; i < testLifetime; i++) {
			gen = ++gen % len; // Handle oscillators of any period length
			testGame.tick();
			assertEquals(knownGenerations[gen], testGame.serialize());
		}
	}
}

