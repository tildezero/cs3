
/**
 * Write a description of class Lab21With10Clients here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab21With10Clients
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Lab21With10Clients
     */
    public static void main(String[] args) {
        for (int i = 0; i < 210; i++) {
            new TicTacToeClient();
        }
        
    }
    
}
