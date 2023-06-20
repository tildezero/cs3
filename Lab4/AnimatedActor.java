import mayflower.*;

public class AnimatedActor extends Actor {
    private Animation animation;
    private Timer animationTimer;
    
    public AnimatedActor() {
        animationTimer = null;
        animation = null;
    }
    
    public void setAnimation(Animation a) {
        animation = a;
        animationTimer = new Timer(animation.getFrameRate());
    }
 
    public void act() {
        if (animation != null && animationTimer != null && animationTimer.isDone()) {
            MayflowerImage m = animation.getNextFrame();
            setImage(m);
            animationTimer.reset();
        }
    }
}