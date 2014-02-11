package com.cheine.jgameoflife;

abstract class Time {
	private int currentTick = 0;
	
	public void tick() {
		currentTick++;
	}
	
	public int elapsedTicks() {
		return currentTick;
	}
}