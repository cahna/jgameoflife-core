package com.cheine.jgameoflife;

import java.io.IOException;
import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final String blockMap = 
			"0000\n" +
			"0110\n" +
			"0110\n" +
			"0000\n";
	
	private static final String beehiveMap = 
			"000000\n" +
			"001100\n" +
			"010010\n" +
			"001100\n" +
			"000000\n";
	
	private static final String lwssMap = 
			"0000000\n" +
            "0100100\n" +
            "0000010\n" +
            "0100010\n" +
            "0011110\n" +
            "0000000\n" +
            "0000000\n";
	
	private static final String gliderMap = 
			"00000000\n" +
            "00010000\n" +
            "01010000\n" +
            "00110000\n" +
            "00000000\n" +
            "00000000\n" +
            "00000000\n";
	
    public static void main( String[] args ) throws ParseException, IOException
    {
    	String seed = "01000\n10011\n11001\n01000\n10001\n";
    	
        System.out.println( "Conway's Game of Life\n\n" );
        System.out.println( "Seed:\n" + seed );
        
        GameOfLife g = new GameOfLife(seed);
        
        while(true) {
        	System.in.read();
        	g.tick();
        	System.out.println(g.serialize());
        }
    }
}
