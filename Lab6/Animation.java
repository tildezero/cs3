import mayflower.*;

public class Animation {
    private int framerate;
    private MayflowerImage[] frames;
    private int currentFrame;

    public Animation(int fr, String[] fns) {
        frames = new MayflowerImage[fns.length];
        for (int i = 0; i < fns.length; i++) {
            frames[i] = new MayflowerImage(fns[i]);
        }
        currentFrame = 0;
        framerate = fr;

    }

    public int getFrameRate() { return framerate; }

    public MayflowerImage getNextFrame() {
        MayflowerImage re = frames[currentFrame];
        currentFrame += 1;
        currentFrame %= frames.length;
        return re;
    }

    public void scale(int w, int h) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].scale(w, h);
        }
    }

    public void setTransparency(int percent) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].setTransparency(percent);
        }
    }

    public void mirrorHorizontally() {
        for (int i = 0; i < frames.length; i++) {
            frames[i].mirrorHorizontally();
        }
    }

    public void setBounds(int x, int y, int w, int h) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].crop(x, y, w, h);
        }
    }

}