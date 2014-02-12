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
public class InputTest {

	private int knownWidth;
	private int knownHeight;
	private String initialState;
	private String expectedState;

	public InputTest(int width, int height, String initialState, String expectedNextState) {
		this.knownWidth = width;
		this.knownHeight = height;
		this.initialState = initialState;
		this.expectedState = expectedNextState;
	}

	/**
	 * Generates the parameters to the GameOfLifeInputTest constructor as tuples
	 * such that t[0] is a given state, and t[1] is the known next-state given the
	 * rules of the game.
	 * @return List of {givenState, nextState} tuples of serialized universes
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
				{ 5, 5, "00000\n00000\n00000\n00000\n00000\n", "00000\n00000\n00000\n00000\n00000\n" },
				{ 5, 5, "11111\n11111\n11111\n11111\n11111\n", "00000\n00000\n00000\n00000\n00000\n" },
				{ 5, 5, "01000\n10011\n11001\n01000\n10001\n", "00000\n10111\n11111\n01000\n00000\n" }
			};
		
		return Arrays.asList(data);
	}

	@Test
	public void testLoadValidGameState() {
		GameOfLife testGame = new GameOfLife(initialState);
		assertEquals(knownWidth, testGame.getWidth());
		assertEquals(knownHeight, testGame.getHeight());
		assertEquals(initialState, testGame.serialize());
	}

	@Test
	public void testKnownTransitionSerialize() {
		GameOfLife testGame = new GameOfLife(initialState);
		testGame.tick();
		assertEquals(expectedState, testGame.serialize());
	}
	
	@Test
	public void testKnownTransition() {
		GameOfLife testGame = new GameOfLife(initialState);
		testGame.tick();
		assertEquals(expectedState, testGame.serialize());
	}
}

