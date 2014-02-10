package com.cheine.jgameoflife;

interface Organism extends Time {	
	public boolean isAlive();
	public boolean isDead();
	public void kill();
	public void ressurect();
}