/**
 * 
 */
package com.cheine.jgameoflife;

import java.text.ParseException;

/**
 * @author cheine
 *
 */
public class GameOfLife extends Universe {

	private Cell[][] cells;
	
	/**
	 * Create a new game from a serialized state.
	 * 
	 * @see com.cheine.jgameoflife.Universe#serialize()
	 * @param serialized
	 * @throws ParseException 
	 */
	public GameOfLife(String serialized) throws ParseException {
		this.load(serialized);
	}
	
	/**
	 * Create a new GameOfLife environment with a Universe
	 * of a given width and height. Organisms are populated
	 * via populate().
	 * 
	 * @see com.cheine.jgameoflife.Universe#populate()
	 * @param width
	 * @param height
	 */
	public GameOfLife(int width, int height) {
		cells = new Cell[height][width];
		this.populate();
	}
	
	/**
	 * Populates the current domain with new cells whose living status
	 * is initially set randomly.
	 * 
	 * @see com.cheine.jgameoflife.Universe#populate()
	 */
	protected void populate() {
		// Disallow re-population
		if(populated)
			return;
		
		for(int y = 0; y < this.getHeight(); y++)
			for(int x = 0; x < this.getWidth(); x++)
				cells[y][x] = new Cell(r.nextBoolean());
		
		populated = true;
	}
	
	/**
	 * Parses the living/dead statuses of all cells in a given serialized 
	 * GameOfLife map. 
	 * @param serialized
	 * @return boolean 2D map of living/dead statuses where true=living and false=dead
	 * @throws ParseException
	 */
	private boolean[][] parse(String serialized) throws ParseException {
		String newlinesRemoved;
		try { newlinesRemoved = serialized.replace("\n", ""); } catch(NullPointerException e) {
			throw new ParseException(e.getMessage(), 0);
		}
		
		int nrLen = newlinesRemoved.length();		
		int len = serialized.length();
		int x = 0, y = 0;
		
		// # of \n's should equal the # of columns
		int height = len - nrLen;
		
		// First occurrence of \n should mark end of first row
		int width = serialized.indexOf('\n');
		
		// Check bounds
		if(height < 1)
			throw new ParseException("Invalid column count", height);
		if(width < 1)
			throw new ParseException("Invalid row count", width);
		
		// Ensure serialized string represents: area = width*height
		int area = width*height;
		if(area != nrLen)
			throw new ParseException("Invalid area (width*height). Expected: " + nrLen, area);
		
		// Use map to store parse results.
		boolean[][] map = new boolean[height][width];
		
		for(int cIndex = 0; cIndex < len; cIndex++) {
			// Check row/column bounds
			if(x > width)
				throw new ParseException("Row is too wide.", cIndex);
			if(y > height)
				throw new ParseException("Too many columns (delimited by newline)", cIndex);
			
			char c;
			try { c = serialized.charAt(cIndex); } catch(IndexOutOfBoundsException e) {
				throw new ParseException(e.getMessage(), cIndex);
			}
			
			boolean isAlive = false;
			switch(c) {
				case '1':
					isAlive = true;
				case '0':
					try { map[y][x] = isAlive; } catch(IndexOutOfBoundsException e) {
						throw new ParseException("Row/Column Mismatch: " + e.getLocalizedMessage(), cIndex);
					}
					x++;
					break;
				case '\n':
					// Check this row&col length so all are the same width
					if(cIndex > 0 && x == width) {
						// End of row, shift to start of next column
						x = 0;
						y++;
					} else {
						throw new ParseException("Unexpected newline", cIndex);
					}					
					break;
				default:
					throw new ParseException("Invalid character: " + c, cIndex);
			}
		}
		
		return map;
	}
	
	/**
	 * Loads a population from a valid serialized string.
	 * 
	 * @throws ParseException 
	 * @see com.cheine.jgameoflife.Universe#load(String)
	 */
	protected void load(String serialized) throws ParseException {
		// Disallow re-population.
		if(populated)
			return;
		
		// Parse the string before committing changes to ensure atomicity of load()
		boolean[][] map = parse(serialized);
		
		int height = map.length;
		int width = map[0].length;
		
		cells = new Cell[height][width];
		
		for(int y = 0; y < height; y++)
			for(int x = 0; x < width; x++)
				cells[y][x] = new Cell(map[y][x]);
		
		populated = true;
	}
	
	/**
	 * Calculates the number of living neighbors for a given cell location.
	 * @param x
	 * @param y
	 * @return integer number of living neighbors out of a possible 8
	 */
	private static int getLivingNeighbors(boolean[][] map, int x, int y) {
		int n = 0, height = map.length, width = map[0].length;
		
		int north = y-1 < 0 ? height-1 : (y-1);
		int south = y+1 >= height ? 0 : (y+1);
		int west  = x-1 < 0 ? width-1 : (x-1);
		int east  = x+1 >= width ? 0 : (x+1);
		
		if(map[north][x])
			n++;
		if(map[north][east])
			n++;
		if(map[y][east])
			n++;
		if(map[south][east])
			n++;
		if(map[south][x])
			n++;
		if(map[south][west])
			n++;
		if(map[y][west])
			n++;
		if(map[north][west])
			n++;
				
		return n;
	}
	
	/**
	 * Implements the rules to Conway's game of life
	 * @see com.cheine.jgameoflife.Time#tick()
	 */
	public void tick() {
		super.tick();
		
		int width = getWidth(), height = getHeight();
		boolean[][] map = getStatusMap();
		
		System.out.println(serialize());
		
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				int liveNeighbors = getLivingNeighbors(map, x, y);
				
				if(map[y][x] == true) {
					// Under-population or Over-population kills
					if(liveNeighbors < 2 || liveNeighbors > 3)
						cells[y][x].kill();
				} else {
					// Dead cell with exactly 3 live neighbors will come to life
					if(liveNeighbors == 3)
						cells[y][x].resurrect();
				}
			}
		}
	}

	/**
	 * @see com.cheine.jgameoflife.Universe#getStatusMap()
	 */
	public boolean[][] getStatusMap() {
		int height = getHeight();
		int width = getWidth();
		boolean[][] map = new boolean[height][width];
		
		for(int y = 0; y < height; y++)
			for(int x = 0; x < width; x++)
				map[y][x] = cells[y][x].isAlive();
		
		return map;
	}

	/**
	 * @see com.cheine.jgameoflife.Universe#getWidth()
	 */
	public int getWidth() {
		return cells[0].length;
	}

	/**
	 * @see com.cheine.jgameoflife.Universe#getHeight()
	 */
	public int getHeight() {
		return cells.length;
	}

	/**
	 * @see com.cheine.jgameoflife.Universe#serialize()
	 */
	public String serialize() {
		StringBuilder serialized = new StringBuilder();
		
		for(int y = 0; y < cells.length; y++) {
			for(int x = 0; x < cells[0].length; x++) {
				serialized.append(cells[y][x].isAlive() ? '1' : '0');
			}
			serialized.append('\n');
		}
		
		return serialized.toString();
	}
}
