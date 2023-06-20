import mayflower.*;
public class Yarn extends Actor
{

    public Yarn()
    {
        setImage("img/yarn.png");
    }


    public void act()
    {
        if (isTouching(Cat.class)) 
        {
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            
            World w = getWorld();
            w.removeObject(this);
            
            c.increaseScore(1);
        }        
    }
}
