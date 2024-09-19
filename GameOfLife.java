import java.util.Scanner;
public class GameOfLife
{
    // Main function to compile the program.
    public static void main(String[] args)
    {
        int iter;
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to use a preset? (y/n)");
        if (sc.next().charAt(0) ==  'y') // For presets.
        {
            System.out.println("1 - Glider" + "\n" + "2 - UFO" + "\n" + "3 - Acorn" + "\n" + "4 - Symmetry" + "\n" + "5 - Fuse");
            int prst = sc.nextInt();
            Board ob = new Board(30,30);
            System.out.println("How many iterations?");
            iter = sc.nextInt();
            ob.presetUse(prst);
            for (int i = 0; i < iter; i ++)
            {
                if (i == 0)
                {   
                    ob.printLife();
                }    
                ob.updateLife();
                ob.printLife();
            }
        }
        else // For a custom grid.
        {
            System.out.println("How many rows in the grid?");
            int row = sc.nextInt();
            System.out.println("How many columns in the grid?");
            int col = sc.nextInt();
            Board ob = new Board(row,col);
            System.out.println("How many cells do you want to place?");
            int cells = sc.nextInt();
            System.out.println("How many iterations?");
            iter = sc.nextInt();
            for (int k = 0; k < cells; k++)
            {
                int count = 1;
                System.out.println("Row of cell " + count);
                row = sc.nextInt() - 1;
                System.out.println("Column of cell " + count);
                col = sc.nextInt() - 1;
                ob.board[row][col].changeState(1);
                count++;
            }
            for (int i = 0; i < iter; i ++)
            {
                if (i == 0)
                {   
                    ob.printLife();
                }    
                ob.updateLife();
                ob.printLife();
            }
        }
    }
}

/**
 * Do you want to use a preset? (y/n)
 * 
    y
    
    1 - Glider
    2 - UFO
    3 - Acorn
    4 - Symmetry
    5 - Fuse
    
    2
    
    How many iterations?
    
    100
    
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ ■ ■ ■ □ ■ ■ □ ■ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ ■ □ ■ ■ □ □ □ □ ■ ■ □ ■ ■ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ ■ ■ ■ □ □ □ ■ □ □ ■ □ ■ □ □ ■ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ ■ □ □ □ ■ □ □ □ ■ □ □ □ □ □ ■ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ ■ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ 
    □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □ □
    (100 frames of the animations are shown)
 */

