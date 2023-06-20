import mayflower.*;

public class Cat extends AnimatedActor
{
    private Animation walk;

    public Cat() 
    {
        String[] imgs = new String[10];
        for (int i = 0; i < imgs.length; i++) {
            imgs[i] = String.format("img/cat/Walk (%d).png", i + 1);
        }

        walk = new Animation(50000000, imgs);
        setAnimation(walk);
        
        walk.scale(100, 87);
        walk.setTransparency(50);

    }

    public void act()
    {
        super.act();
        
    }
}
