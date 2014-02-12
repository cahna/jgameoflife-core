
jgameoflife
===========

Heavily-OO Java implementation of [Conway's game of life](http://en.wikipedia.org/wiki/Conway's_Game_of_Life).
Includes a package for creating and managing game behavior (to, for example, implement custom interfaces),
a suite of JUnit4 tests, and build/test/dependency management with Maven.

The GameOfLife class implements the 2D game as a toroidal array (ie. running off the right edge will wrap
around to the left edge, same with the top and bottom edges, and vice versa), rather than considering cells
outside of the array bounds as dead.

Author
======

```
Conor Heine <conor.heine@gmail.com>
```

