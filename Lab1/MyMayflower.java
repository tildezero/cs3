import mayflower.*;
/**
 * Write a description of class MyMayflower here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyMayflower extends Mayflower
{
    /**
     * Constructor for objects of class MyMayflower
     */
    public MyMayflower()
    {
        super("Lab 1", 800, 600);
    }
    
    public void init() 
    {
        Mayflower.setFullScreen(false);
        World w = new MyWorld();
        Mayflower.setWorld(w);
    }
}
