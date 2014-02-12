package com.cheine.jgameoflife.GameOfLifeTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.cheine.jgameoflife.GameOfLife;

@RunWith(Parameterized.class)
public class SpaceshipTest extends KnownBehaviorTest {
	
	public SpaceshipTest(String[] knownGenerations) {
		super(knownGenerations);
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
			{ 
				// Lightweight Spaceship
				new String[] {
					// Step 1
					"0000000\n" +
		            "0100100\n" +
		            "0000010\n" +
		            "0100010\n" +
		            "0011110\n" +
		            "0000000\n" +
		            "0000000\n",
		            
		            "0000000\n" +
		            "0000000\n" +
		            "0000110\n" +
		            "0011011\n" +
		            "0011110\n" +
		            "0001100\n" +
		            "0000000\n",
		            
		            "0000000\n" +
		            "0000000\n" +
		            "0001111\n" +
		            "0010001\n" +
		            "0000001\n" +
		            "0010010\n" +
		            "0000000\n",
		            
		            "0000000\n" +
		            "0000110\n" +
		            "0001111\n" +
		            "1001101\n" +
		            "0000011\n" +
		            "0000000\n" +
		            "0000000\n",
		            
		            "0000000\n" +
					"0001001\n" +
					"1000000\n" +
					"1001000\n" +
					"1000111\n" +
					"0000000\n" +
					"0000000\n",
					
					"0000000\n" +
					"0000000\n" +
					"1000001\n" +
					"1100110\n" +
					"1000111\n" +
					"0000011\n" +
					"0000000\n",
					
					"0000000\n" +
					"0000000\n" +
					"1100011\n" +
					"0100100\n" +
					"0100000\n" +
					"1000100\n" +
					"0000000\n",
					
					"0000000\n" +
					"1000001\n" +
					"1100011\n" +
					"0110011\n" +
					"1100000\n" +
					"0000000\n" +
					"0000000\n",
					
					"0000000\n" +
					"0100010\n" +
					"0010000\n" +
					"0010010\n" +
					"1110001\n" +
					"0000000\n" +
					"0000000\n",
					
					"0000000\n" +
					"0000000\n" +
					"0110000\n" +
					"1011001\n" +
					"1110001\n" +
					"1100000\n" +
					"0000000\n",
					
					"0000000\n" +
					"0000000\n" +
					"1111000\n" +
					"0001001\n" +
					"0001000\n" +
					"0010001\n" +
					"0000000\n",
					
					"0000000\n" +
					"0110000\n" +
					"1111000\n" +
					"1101100\n" +
					"0011000\n" +
					"0000000\n" +
					"0000000\n"
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
	public void testPredestination() throws ParseException {
		int gen = 0, len = knownGenerations.length;
		
		// Start the game
		GameOfLife testGame = new GameOfLife(knownGenerations[gen]);
		
		for(int i = 0; i < len; i++) {
			assertEquals(knownGenerations[i], testGame.serialize());
			testGame.tick();			
		}
	} 
}

