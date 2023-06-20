import mayflower.*;

public class MyWorld extends World
{
    // Constructor
    public MyWorld()
    {
        setBackground("img/BG/BG.png");

        Cat cat = new Cat();
        addObject(cat, 100, 100);
        
        
        Jack j = new Jack();
        addObject(j, 200, 200);
    }

    public void act()
    {
    }
}
