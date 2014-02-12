/**
 * 
 */
package com.cheine.jgameoflife;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author cheine
 *
 */
public class CellTest {

	/**
	 * Test method for {@link com.cheine.jgameoflife.Cell#Cell(boolean)}.
	 */
	@Test
	public void testCellBoolean() {
		Cell alive = new Cell(true);
		assertTrue(alive.isAlive());
		assertFalse(alive.isDead());
		
		Cell dead = new Cell(false);
		assertTrue(dead.isDead());
		assertFalse(dead.isAlive());
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.Cell#Cell()}.
	 */
	@Test
	public void testCell() {
		Cell defaultCell = new Cell();
		assertTrue(defaultCell.isDead());
		assertFalse(defaultCell.isAlive());
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.Cell#isAlive()}.
	 */
	@Test
	public void testIsAlive() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.Cell#isDead()}.
	 */
	@Test
	public void testIsDead() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.Cell#kill()}.
	 */
	@Test
	public void testKill() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.Cell#ressurect()}.
	 */
	@Test
	public void testRessurect() {
		fail("Not yet implemented");
	}

}
