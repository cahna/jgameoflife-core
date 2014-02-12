package com.cheine.jgameoflife;

interface Organism {	
	public boolean isAlive();
	public boolean isDead();
	public void kill();
	public void ressurect();
}