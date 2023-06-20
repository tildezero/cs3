import mayflower.*;

public class Ninja extends AnimatedActor
{
    private Animation walk;

    public Ninja() 
    {
        String[] imgs = new String[10];
        for (int i = 0; i < imgs.length; i++) {
            imgs[i] = String.format("img/ninjagirl/Jump_Attack__00%d.png", i);
        }

        walk = new Animation(50000000, imgs);
        setAnimation(walk);
        
        walk.scale(50, 200);
        walk.setTransparency(56);

    }

    public void act()
    {
        super.act();
        
    }
}
