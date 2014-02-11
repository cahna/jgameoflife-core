package com.cheine.jgameoflife.GameOfLifeTest;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Period2OscillatorTest extends KnownBehaviorTest {
	
	public Period2OscillatorTest(String[] knownGenerations) {
		super(knownGenerations);
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
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
					// Beacon (period 2)
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
}

