public class Cell
{
    int state;
    
    void changeState(int x)
    {
        state = x;
    }
    
    // Prints a black square for a living cell and an empty square for a dead cell.
    void printCell()
    {
        if (this.state == 0)
        {
            System.out.print('\u25A1' + " ");
        }
        else
        {
            System.out.print('\u25A0' + " ");
        }
    }
}
