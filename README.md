
jgameoflife
===========

Heavily-OO Java implementation of [Conway's game of life](http://en.wikipedia.org/wiki/Conway's_Game_of_Life).
Includes a package for creating and managing game behavior (to, for example, implement custom interfaces),
a suite of JUnit4 tests, and build/test/dependency management with Maven.

The GameOfLife class implements the 2D game as a toroidal array (ie. running off the right edge will wrap
around to the left edge, same with the top and bottom edges, and vice versa), rather than considering cells
outside of the array bounds as dead.

Usage
=====

## Interactive Examples ##

1. Get the sources

    ```
    $ git clone https://github.com/cahna/jgameoflife-all.git
    $ cd jgameoflife-all
    $ git submodule init && git submodule update
    ```

2. Compile/test/package with Maven

    ```
    $ mvn package
    ```

3. Choose usage:

    * Run any/all example interfaces

    ```
    $ java -cp jgameoflife-core/target/jgameoflife-core-0.0.1-SNAPSHOT.jar:. jgameoflife-cli/target/jgameoflife-cli-0.0.1-SNAPSHOT
    $ java -cp jgameoflife-core/target/jgameoflife-core-0.0.1-SNAPSHOT.jar:. jgameoflife-cli/target/jgameoflife-curses-0.0.1-SNAPSHOT
    $ java -cp jgameoflife-core/target/jgameoflife-core-0.0.1-SNAPSHOT.jar:. jgameoflife-cli/target/jgameoflife-piccolo2d-0.0.1-SNAPSHOT
    ```

    * Use core library in your own Java project

    _Put jgameoflife-core in your code's project path manually, via Maven dependency, or however else you feel like doing it._

    ```java
    package my.game.thing;

    import com.cheine.jgameoflife.GameOfLife;
    import java.io.IOException;
    import java.text.ParseException;
    import java.util.Scanner;

    public class App
    {
        private static final Scanner in = new Scanner(System.in);
  
        public static void main( String[] args )
        {
            GameOfLife game = new GameOfLife(42, 21);

            System.out.println("Press ENTER to begin game loop, and again (repeatedly) to step through the game.");
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
    }

    ```

Author
======

```
Conor Heine <conor.heine@gmail.com>
```

