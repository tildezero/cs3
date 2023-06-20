import mayflower.*;
/**
 * Write a description of class Cat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cat extends Actor
{
    public Cat()
    {
        setImage("img/cat.png");
    }
    public void act()
    {
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && (x + 1 + w <= 800)) {
            setLocation(x + 1, y);
        } else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && (x - 1 >= 0)) {
            setLocation(x - 1, y);
        } else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) && (y + 1 + h <= 600)) {
            setLocation(x, y + 1);
        } else if (Mayflower.isKeyDown(Keyboard.KEY_UP) && (y - 1 >= 0)) {
            setLocation(x, y - 1);
        }
    }
}
