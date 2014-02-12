package com.cheine.jgameoflife;

import java.text.ParseException;
import java.util.Random;

abstract class Universe extends Time {
	/**
	 * Using universal random so all things that need a random use this one.
	 * This will allow for things like:
	 *  - Seeding the RNG for testing on known outcomes
	 *  - Ensuring everything uses the same RNG
	 */
	public static Random r = new Random();
	
	/**
	 * Only allow the Universe to be populated/seeded once.
	 */
	protected boolean populated = false;
	
	/**
	 * Technically, Universe is an implementation to a domain consisting	  
	 * of binary-state organisms. We only want to be able to observe the
	 * alive/dead status of the constituents. To abstract the implementation
	 * of alive/dead, to protect access to Organism control, and so the game 
	 * may be run on a separate thread (say, from a GUI), this method will
	 * generate a snapshot of the universe at the current tick in Time.
	 *
	 * @return boolean[][] 2D map of living status of organisms in universe 
	 */
	public abstract boolean[][] getStatusMap();
	
	/**
	 * Retrieves the width of the implementation of the Universe's
	 * area (not necessarily the width of the Universe, eg. a 
	 * toroidal universe implemented with a 2D array of connected 
	 * edges).
	 * 
	 * @return integer width of the data structure representing
	 * the Universe's domain
	 */
	public abstract int getWidth();
	
	/**
	 * @see com.cheine.jgameoflife.Universe#getHeight()
	 * 
	 * @return integer height of the data structure representing
	 * the Universe's domain
	 */
	public abstract int getHeight();
	
	/**
	 * Create a meaningful string representation of the Universe's 
	 * current state. Output should be able to be passed to load()
	 * as a valid form of seeding a new Universe from the current
	 * state.
	 * 
	 * @see com.cheine.jgameoflife.Universe#load(String)
	 * @return string representing current binary state of all Organisms
	 * within the Universe
	 */
	public abstract String serialize();
	
	/**
	 * Seed the Universe with a given state. Any Universe serialized
	 * with serialize() should be a valid parameter for load().
	 * 
	 * @see com.cheine.jgameoflife.Universe#serialize()
	 * @param serialized Valid String representation of Universe state. 
	 * @throws ParseException 
	 */
	protected abstract void load(String serialized) throws ParseException;
	
	/**
	 * Populates the current domain with new cells whose living status
	 * is initially set randomly.
	 * 
	 * @see com.cheine.jgameoflife.Universe#populate()
	 */
	protected abstract void populate();
}
