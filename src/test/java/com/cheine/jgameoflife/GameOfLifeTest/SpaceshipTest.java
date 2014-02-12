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
			            "0000000\n" +
			            "1000100\n" +
			            "0000010\n" +
			            "1000010\n" +
			            "0111100\n" +
			            "0000000\n" +
			            "0000000\n",
			            // Step 2
			            "0000000\n" +
			            "0000000\n" +
			            "0001100\n" +
			            "0110110\n" +
			            "0111100\n" +
			            "0011000\n" +
			            "0000000\n",
			            // Step 3
			            "0000000\n" +
			            "0000000\n" +
			            "0011110\n" +
			            "0100010\n" +
			            "0000010\n" +
			            "0100100\n" +
			            "0000000\n",
			            // Step 4
			            "0000000\n" +
			            "0011000\n" +
			            "0111100\n" +
			            "0110110\n" +
			            "0001100\n" +
			            "0000000\n" +
			            "0000000\n",
			
			            // Repeat steps to create loop within infinite toroidal universe
			            "0000000\n" +
			            "0100010\n" +
			            "0000001\n" +
			            "0100001\n" +
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
			
			            // Continuing
			            "0000000\n" +
			            "1001000\n" +
			            "0100000\n" +
			            "0101000\n" +
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
			
			            // Continuing
			            "0000000\n" +
			            "0010010\n" +
			            "0001000\n" +
			            "0001010\n" +
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
}

