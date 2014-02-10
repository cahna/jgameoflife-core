package com.cheine.jgameoflife;

interface Universe extends Time {
	public boolean[][] getStatusMap();
	public void clear();
	public int getWidth();
	public int getHeight();
	public void populate();
	public String toString();
}
