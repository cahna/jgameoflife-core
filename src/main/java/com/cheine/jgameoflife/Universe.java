package com.cheine.jgameoflife;

public interface Universe {
	public void nextGeneration();
	public void getGenerationCount();
	public CellStatus[][] getState();
}
