import mayflower.*;

public class Dog extends AnimatedActor
{
    private Animation walk;

    public Dog() 
    {
        String[] imgs = new String[8];
        for (int i = 0; i < imgs.length; i++) {
            imgs[i] = String.format("img/Dog/Jump (%d).png", i + 1);
        }

        walk = new Animation(50000000, imgs);
        setAnimation(walk);
        
        walk.scale(100, 100);
        walk.setTransparency(0);

    }

    public void act()
    {
        super.act();
        
    }
}
