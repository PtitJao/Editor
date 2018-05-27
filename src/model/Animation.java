package model;

import javafx.scene.image.Image;

public class Animation extends Graphics {

    private AnimationInfo [] animations;

    public Animation(String name, Image image, AnimationInfo[] animations) {
        super(name, image);
        this.animations = animations;
    }

    public AnimationInfo[] getAnimations() {
        return animations;
    }

    public void setAnimations(AnimationInfo[] animations) {
        this.animations = animations;
    }
}
