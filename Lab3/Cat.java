import mayflower.*;

public class Cat extends Actor
{
    private MayflowerImage[] frames;
    private int currentFrame;
    private Timer animationTimer;
    public Cat()
    {
        frames = new MayflowerImage[10];
        currentFrame = 0;
        for (int i = 0; i < 10; i++) {
            frames[i] = new MayflowerImage(String.format("img/cat/Walk (%d).png", i + 1));
            frames[i].scale(100, 87);
        }
        animationTimer = new Timer(100000000);
    }
    
    public void act()
    {
        if (animationTimer.isDone()) {
            animationTimer.reset();
            currentFrame %= frames.length;
            setImage(frames[currentFrame]);
            currentFrame++;
        }
    }
}
