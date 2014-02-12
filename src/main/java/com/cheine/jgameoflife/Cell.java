/**
 * 
 */
package com.cheine.jgameoflife;

/**
 * @author cheine
 *
 */
public class Cell implements Life {

	protected boolean status;
	
	/**
	 * Create a cell whose life status corresponds to the value
	 * of initialState (ie. true:alive ; false:dead)
	 * 
	 * @param initialState Whether to create the cell as initially
	 * living or initially dead
	 */
	public Cell(boolean initialState) {
		this.status = initialState;
	}
	
	/**
	 * Create a non-living cell.
	 */
	public Cell() {
		this(false);
	}
	
	/**
	 * @see com.cheine.jgameoflife.Life#isAlive()
	 */
	public boolean isAlive() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @see com.cheine.jgameoflife.Life#isDead()
	 */
	public boolean isDead() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @see com.cheine.jgameoflife.Life#kill()
	 */
	public void kill() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @see com.cheine.jgameoflife.Life#resurrect()
	 */
	public void resurrect() {
		throw new UnsupportedOperationException();
	}

}
