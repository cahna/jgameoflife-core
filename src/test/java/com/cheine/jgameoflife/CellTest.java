/**
 * 
 */
package com.cheine.jgameoflife;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cheine.jgameoflife.Cell;

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
		Cell testCell = new Cell();
		testCell.resurrect();
		assertTrue(testCell.isAlive());
		testCell.kill();
		assertFalse(testCell.isAlive());
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.Cell#isDead()}.
	 */
	@Test
	public void testIsDead() {
		Cell testCell = new Cell();
		testCell.kill();
		assertTrue(testCell.isDead());
		testCell.resurrect();
		assertFalse(testCell.isDead());
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.Cell#kill()}.
	 */
	@Test
	public void testKill() {
		Cell testCell = new Cell(true);
		assertEquals(testCell.isAlive(), !testCell.isDead());
		testCell.kill();
		assertEquals(testCell.isDead(), !testCell.isAlive());
	}

	/**
	 * Test method for {@link com.cheine.jgameoflife.Cell#resurrect()}.
	 */
	@Test
	public void testresurrect() {
		Cell testCell = new Cell(false);
		assertEquals(testCell.isDead(), !testCell.isAlive());
		testCell.resurrect();
		assertEquals(testCell.isAlive(), !testCell.isDead());
	}

}
