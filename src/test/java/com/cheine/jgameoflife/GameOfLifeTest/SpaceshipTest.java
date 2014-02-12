package com.cheine.jgameoflife.GameOfLifeTest;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

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
						"0000000000\n" +
						"0010001000\n" +
						"0000000100\n" +
						"0010000100\n" +
						"0001111000\n" +
						"0000000000\n" +
						"0000000000\n",
						// Step 2
						"0000000000\n" +
						"0000000000\n" +
						"0000011000\n" +
						"0001101100\n" +
						"0001111000\n" +
						"0000110000\n" +
						"0000000000\n",
						// Step 3
						"0000000000\n" +
						"0000000000\n" +
						"0000011110\n" +
						"0000100010\n" +
						"0000000010\n" +
						"0000100100\n" +
						"0000000000\n",
						// Step 4
						"0000000000\n" +
						"0000001100\n" +
						"0000011110\n" +
						"0000011011\n" +
						"0000000110\n" +
						"0000000000\n" +
						"0000000000\n",
						// Repeat steps to create loop within infinite toroidal universe
						"0000000000\n" +
						"1000001000\n" +
						"0100000000\n" +
						"0100001000\n" +
						"1000000111\n" +
						"0000000000\n" +
						"0000000000\n",
						
						"0000000000\n" +
						"0000000000\n" +
						"1000000001\n" +
						"1100000110\n" +
						"1000000111\n" +
						"0000000011\n" +
						"0000000000\n",
						
						"0000000000\n" +
						"0000000000\n" +
						"1111000000\n" +
						"0001000001\n" +
						"0001000000\n" +
						"0010000001\n" +
						"0000000000\n",
						
						"0000000000\n" +
						"0110000000\n" +
						"1111000000\n" +
						"1101100000\n" +
						"0011000000\n" +
						"0000000000\n" +
						"0000000000\n"
					} 
				}
			};
		
		return Arrays.asList(data);
	}
}

