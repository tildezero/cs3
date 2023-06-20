import mayflower.*;
/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public MyWorld() 
    {
        setBackground("img/bluebonnets.jpg");
        Cat c = new Cat();
        addObject(c, 400, 300);

        Dog d = new Dog();
        addObject(d, 200, 150);

        Yarn y1 = new Yarn();
        Yarn y2 = new Yarn();
        Yarn y3 = new Yarn();

        addObject(y1, 600, 150);
        addObject(y2, 200, 450);
        addObject(y3, 600, 450);
        
        showText("Score: " + c.getScore() + " Lives: ?", 10, 30, Color.BLACK);
    }

    public void act() 
    {

    }
}
