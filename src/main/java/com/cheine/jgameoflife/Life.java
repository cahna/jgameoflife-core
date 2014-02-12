package com.cheine.jgameoflife;

interface Life {
	/**
	 * @return True if organism is alive (implementation-agnostic), 
	 * false otherwise.
	 */
	public boolean isAlive();
	
	/**
	 * @return True if organism is dead (implementation-agnostic), 
	 * false otherwise.
	 */
	public boolean isDead();
	
	/**
	 * Kill the organism.
	 */
	public void kill();
	
	/**
	 * Make the organism living.
	 */
	public void resurrect();
}