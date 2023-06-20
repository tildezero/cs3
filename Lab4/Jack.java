
import mayflower.*;

public class Jack extends AnimatedActor
{
    private Animation walk;

    public Jack() 
    {
        String[] imgs = new String[10];
        for (int i = 0; i < imgs.length; i++) {
            imgs[i] = String.format("img/jack/Slide (%d).png", i + 1);
        }

        walk = new Animation(50000000, imgs);
        setAnimation(walk);
        
        walk.scale(100, 150);
        walk.setTransparency(10);

    }

    public void act()
    {
        super.act();
        
    }
}
