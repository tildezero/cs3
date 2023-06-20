import mayflower.*;
/**
 * Write a description of class Cat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cat extends Actor
{
    private int score;
    private int lives;
    public Cat()
    {
        setImage("img/cat.png");
        score = 0;
        lives = 3;
    }
    public void act()
    {
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        updateText();
        
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && (x + 1 + w <= 800)) {
            setLocation(x + 1, y);
        } else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && (x - 1 >= 0)) {
            setLocation(x - 1, y);
        } else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) && (y + 1 + h <= 600)) {
            setLocation(x, y + 1);
        } else if (Mayflower.isKeyDown(Keyboard.KEY_UP) && (y - 1 >= 0)) {
            setLocation(x, y - 1);
        }
        
        if (isTouching(Dog.class)) {
            lives--;
            setLocation(400, 300);
        }
        
        if (lives <= 0) {
            updateText();
            World mw = getWorld();
            mw.removeObject(this);
        }
        

    }
    
    public void increaseScore(int amount) { score++; }

    public int getScore() { return score; }
    
    private void updateText() {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }
}
