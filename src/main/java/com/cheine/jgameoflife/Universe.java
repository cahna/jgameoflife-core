package com.cheine.jgameoflife;

interface Universe extends Time {
	public boolean[][] getStatusMap();
	public void clear();
	public int getWidth();
	public int getHeight();
	public void populate(int width, int height);
	public String serialize();
	public void load(String serialized);
}
