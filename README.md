## Game-of-Life
Terminal simulation of John Conway's Game of Life, with five presets, and custom inputs.

This programme is made to simply observe simulations of [John Conway's Game of Life]([url](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)). *Cell.java* and *Board.java* are supplementary classes to the main class *GameOfLife.java*. 

# How to run:

1. Simply run the *main* function from *GameOfLife.java*.
2. Enter 'y' to use presets,and 'n' to not
   - If you choose to use presets, you will be prompted to enter a number for the corresponding preset.
   - Once you enter the number, you will be asked for the number of iterations or frames you want to see. (Note: In order to observe the simulation properly, a number greater than atleast 30 is recommended for the iterations.)

3. If you wish to input a custom layout, enter the number of rows and column on your board/grid.
4. Next, enter the number of cells you wish to place.
5. Now enter the number of iterations you wish to see.
6. Finally, enter the coordinates of all the cells on the board, in terms of rows and columns.
7. Now you should be able to see a simulation.

# Additional Information:

This project also enables cells to grow laterally across the plane. The board is looped, such that cells that grow out of the right side, will come back in from the left. The same is true for vertically growing cells. However, one of the project's shortcomings is that it fails to accomodate the same foe the corners. As we are dealing with a square, we cannot fully wrap it around a sphere. Therefore, cells that reach the corners cannot grow further.
