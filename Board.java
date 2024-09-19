        public class Board
{
    Cell[][] board;
    
    // Constructor
    Board(int row,int col)
    {
        board = new Cell[row][col];
        // Initializes all the cells and creates an object on the entire grid.
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                board[i][j] = new Cell();
            }
        }
    }
    
    // A function which returns the number of cells that are alive around the given cell.
    // Includes all the possible cases.
    int surrounding(int x, int y, Cell[][] temp)
    {
        int count = 0;
        if (x < temp.length - 1 && temp[x+1][y].state == 1)
        {
            count++;
        }
        if (x < temp.length - 1 && y < temp[0].length - 1 && temp[x+1][y+1].state == 1)
        {
            count++;
        }
        if (y < temp[0].length - 1 && temp[x][y+1].state == 1)
        {
            count++;
        }
        if (x < temp.length - 1 && y != 0 && temp[x+1][y-1].state == 1)
        {
            count++;
        }
        if (y!= 0 && temp[x][y-1].state == 1)
        {
            count++;
        }
        if (x > 0 && temp[x-1][y].state == 1)
        {
            count++;
        }
        if (x > 0  && y < temp[0].length - 1 && temp[x-1][y+1].state == 1)
        {
            count++;
        }
        if (x > 0 && y != 0 && temp[x-1][y-1].state == 1)
        {
            count++;
        }
        if (x == 0)
        {
            if (temp[temp.length-1][y].state == 1)
            {
                count++;
            }
            if (y!=temp[0].length - 1 && temp[temp.length-1][y+1].state == 1)
            {
                count++;
            }
            if (y!=0 && temp[temp.length-1][y-1].state == 1)
            {
                count++;
            }
        }
        if (y == 0)
        {
            if (x!=0 && temp[x-1][temp[0].length-1].state == 1)
            {
                count++;
            }
            if (temp[x][temp[0].length-1].state == 1)
            {
                count++;
            }
            if(x!=temp.length - 1 && temp[x+1][temp[0].length-1].state == 1)
            {
                count++; 
            }
        }
        if (x == temp.length-1)
        {
            if (temp[0][y].state == 1)
            {
                count++;
            }
            if (y!=temp[0].length - 1 && temp[0][y+1].state == 1)
            {
                count++;
            }
            if (y!=0 && temp[0][y-1].state == 1)
            {
                count++;
            }
        }
        if (y == temp.length-1)
        {
            if (x!=0 && temp[x-1][0].state == 1)
            {
                count++;
            }
            if (temp[x][0].state == 1)
            {
                count++;
            }
            if(x!=temp.length - 1 && temp[x+1][0].state == 1)
            {
                count++; 
            }
        }
        return count;
    }
    
    // Updates the state of a cell according to its surroundings.
    void updateLife()
    {
        // A temporary board to check the cases, changes will be made to the actual board.
        Cell[][] temp = new Cell[board.length][board[0].length];
        // Copies all the values of the original board into the temp.
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                temp[i][j] = new Cell();
                temp[i][j].state = board[i][j].state;
            }
        }
        // Updates the states of the cells.
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                int sur = surrounding(i,j,temp);
                if (temp[i][j].state == 0)
                {
                    if (sur == 3) // Makes the cell alive.
                    {
                        board[i][j].changeState(1);
                    }
                }
                else
                {
                    if (sur < 2) // Dies due to underpopulation.
                    {
                        board[i][j].changeState(0);
                    }
                    if (sur > 3)
                    {
                        board[i][j].changeState(0); // Dies due to overpopulation.
                    }
                }
            }
        }
    }
    
    // Prints each frame of the board to make a seamless animation.
    void printLife()
    {
        System.out.println("\f");
        long end = System.currentTimeMillis() + 30*13;
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                board[i][j].printCell();
            }
            System.out.println();
        }
        while(System.currentTimeMillis() < end)
        {
            
        }
    }
    
    // Function to provide presets to the user.
    void presetUse(int num)
    {
        switch(num)
        {
            case 1:
                preset1();
                break;
            case 2:
                preset2();
                break;
            case 3:
                preset3();
                break;
            case 4:
                preset4();
                break;
                
            case 5:
                preset5();
                break;
        }
        
    }
    
    // PRESETS.    
    
    void preset1()
    {
        board[0][1].changeState(1);
        board[1][2].changeState(1);
        board[2][2].changeState(1);
        board[2][1].changeState(1);
        board[2][0].changeState(1);
    }
    
    void preset2()
    {
        board[14][6].changeState(1);
        board[15][7].changeState(1);
        board[15][8].changeState(1);
        board[13][7].changeState(1);
        board[13][8].changeState(1);
        board[13][9].changeState(1);
        board[13][10].changeState(1);
        board[12][10].changeState(1);
        board[12][11].changeState(1);
        board[14][11].changeState(1);
        board[13][13].changeState(1);
        board[12][13].changeState(1);
        board[11][13].changeState(1);
        board[13][14].changeState(1);
        board[11][14].changeState(1);
        board[14][15].changeState(1);
        board[12][15].changeState(1);
        board[12][16].changeState(1);
        board[11][16].changeState(1);
        board[12][18].changeState(1);
        board[12][19].changeState(1);
        board[12][20].changeState(1);
        board[13][21].changeState(1);
        board[14][20].changeState(1);
        board[14][19].changeState(1);
    }
    
    void preset3()
    {
        board[12][12].changeState(1);
        board[12][13].changeState(1);
        board[10][13].changeState(1);
        board[12][16].changeState(1);
        board[11][15].changeState(1);
        board[12][17].changeState(1);
        board[12][18].changeState(1);
    }
    
    void preset4()
    {
        for (int i = 3; i <= 20; i++)
        {
            board[12][i].changeState(1);
            board[13][i].changeState(1);
            board[15][i].changeState(1);
            board[16][i].changeState(1);
        }
        board[13][22].changeState(1);
        board[14][23].changeState(1);
        board[12][23].changeState(1);
        board[12][24].changeState(1);
        board[13][25].changeState(1);
        board[14][24].changeState(1);
    }
    
    void preset5()
    {
        for (int i = 3; i <= 20; i++)
        {
            board[12][i].changeState(1);
            board[13][i].changeState(1);
            board[15][i].changeState(1);
            board[16][i].changeState(1);
            if (i%2 == 0)
            {
                i+=2;
            }
        }
        board[13][22].changeState(1);
        board[14][23].changeState(1);
        board[12][23].changeState(1);
        board[12][24].changeState(1);
        board[13][25].changeState(1);
        board[14][24].changeState(1);
    }
}
