# Conway Game Of Life

[Conway's Game of Life](https://conwaylife.com/wiki/Conway%27s_Game_of_Life)  is a cellular automaton that is played on a 2D square grid. Each square (or "cell") on the grid can be either alive or dead, and they evolve according to the following rules:

-   Any live cell with fewer than two live neighbours dies (referred to as underpopulation).
-   Any live cell with more than three live neighbours dies (referred to as overpopulation).
-   Any live cell with two or three live neighbours lives, unchanged, to the next generation.
-   Any dead cell with exactly three live neighbours comes to life.

# Project
Since I am used to code 2D board game that are very similar to GOL , I chose a OOP approach using Java and JavaFX as GUI
I also considered using python and pygame, but I am a Java nerd.
I used IntelliJ.


# Approach

First we initialize the cells in the grid and count for each one of them we compute their neighborhood
Then at each step in the simulation, for each cell in the grid, we update the value of  the given cell based on its neighbors.
Finally, we update the display of grid values.


# What I would like to add
- add the possibility for the player to set the initial state of the cells by clicking on the window
- adding the possibility to set a predetermined percentage of random alive and dead cell when filling the initial state
- handle the input to stop and quit the game or reset it
- gameloop and gameboardview should be distinct
- pimp it with customized  sprites

![enter image description here](https://i.ibb.co/zGv5mNX/Animation.gif)






