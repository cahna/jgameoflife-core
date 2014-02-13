package com.cheine.jgameoflife;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Cli 
{
	@SuppressWarnings("unused")
	private static final HashMap<String, String> exampleGames = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("block", "0000\n0110\n0110\n0000\n");
			put("beehive", "000000\n001100\n010010\n001100\n000000\n");
			put("spaceship", "0000000\n0100100\n0000010\n0100010\n0011110\n0000000\n0000000\n");
			put("glider", "00000000\n00010000\n01010000\n00110000\n00000000\n00000000\n00000000\n");
		}
	};
	
	private static final Scanner in = new Scanner(System.in);
	
    public static void main( String[] args ) throws ParseException, IOException
    {
    	int action = mainMenu();
    	
    	GameOfLife g;
    	switch(action) {
    		case 1:
    			System.out.print("Enter width");
    			int w = getSelection(100);
    			System.out.print("Enter height");
    			int h = getSelection(100);
    			
    			g = new GameOfLife(w,h);
    			
    			break;
    		case 2:
    		default:
    			throw new UnsupportedOperationException();
    	}
    	
    	System.out.println("\n Press enter to start game and to create the next generation. Enter 'quit' to stop.");
    	in.nextLine();
    	
    	while(true) {
    		System.out.println(g.serialize());
    		String opt = in.nextLine();
    		
    		if(opt.equals("quit"))
    			break;
    		
    		g.tick();
    	}
        
        System.out.println("Done.");
        in.nextLine();
        
        in.close();
    }
    
    private static int getSelection(int maxValue) {
    	System.out.print("> [1-"+maxValue+"]: ");
    	
    	int s = 0;
    	
    	try {
    	    s = in.nextInt();
    	    if(s > maxValue || s < 1)
				throw new IOException();
			
		} catch (IOException e) {
			System.out.println("\nERROR: Invalid selection. Try again...");
			return getSelection(maxValue);
		}
    	
    	return s;
    }
    
    private static int mainMenu() {
    	System.out.println( 
    		"Conway's Game of Life\n" +
    		"---------------------\n" +
    		"\n" +
    		" 1) Start a new game\n" +
    		" 2) Load a saved game\n"
    	);
    	
    	return getSelection(2);
    }
}
