package com.cheine.jgameoflife;

interface Universe {
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
	public boolean[][] getStatusMap();
	
	/**
	 * Retrieves the width of the implementation of the Universe's
	 * area (not necessarily the width of the Universe, eg. a 
	 * toroidal universe implemented with a 2D array of connected 
	 * edges).
	 * 
	 * @return integer width of the data structure representing
	 * the Universe's domain
	 */
	public int getWidth();
	
	/**
	 * @see com.cheine.jgameoflife.Universe#getHeight()
	 * 
	 * @return integer height of the data structure representing
	 * the Universe's domain
	 */
	public int getHeight();
	
	/**
	 * Populate the universe.
	 */
	public void populate();
	
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
	public String serialize();
	
	/**
	 * Seed the Universe with a given state. Any Universe serialized
	 * with serialize() should be a valid parameter for load().
	 * 
	 * @see com.cheine.jgameoflife.Universe#serialize()
	 * @param serialized Valid String representation of Universe state. 
	 */
	public void load(String serialized);
}
