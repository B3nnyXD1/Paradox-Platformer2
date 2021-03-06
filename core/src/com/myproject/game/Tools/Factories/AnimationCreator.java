package com.myproject.game.Tools.Factories;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.myproject.game.Screens.PlayScreen;

/**
 * Created by leon on 4/26/17.
 */

public class AnimationCreator {
    private final PlayScreen screen;
    private final Array<TextureRegion> frames = new Array<TextureRegion>();

    public AnimationCreator(PlayScreen screen) {
        this.screen = screen;
    }

    public Array<TextureRegion> addFrames(String assetName, int frameCount, int xCoord, int yCoord, int width, int height) {
        for(int i = 0; i < 5; i++) {
            TextureAtlas.AtlasRegion atlasRegion = screen.getAtlas()[0].findRegion(assetName);
            TextureRegion textureRegion = new TextureRegion(atlasRegion, i * xCoord, yCoord, width, height);
            frames.add(textureRegion);
        }
        return frames;
    }

    public Animation<TextureRegion> createAnimation() {
        Animation<TextureRegion> animation = new Animation(0.1f, frames);
        frames.clear();
        return animation;
    }

    public Animation<TextureRegion> createPlayerRunAnimation() {
        addFrames("ninja_run", 5, 363, 0, 364, 458);
        addFrames("ninja_run", 5, 363, 458, 363, 458);
        return createAnimation();
    }

    public Animation<TextureRegion> createPlayerJumpAnimation() {
        addFrames("ninja_jump", 5, 362, 0, 362, 483);
        addFrames("ninja_jump", 5, 362, 483, 362, 483);
        return createAnimation();
    }


    public Animation<TextureRegion> createPlayerAttackAnimation() {
        addFrames("ninja_attack", 3, 536, 0, 536, 495);
        addFrames("ninja_attack", 3, 0, 495*2, 536, 495);
        return createAnimation();
    }

    public TextureRegion createPlayerStandTexture() {
        return new TextureRegion(screen.getAtlas()[0].findRegion("ninja_idle"), 0, 50, 360, 470);
    }

    public Animation createWalkAnimation() {
        Array<TextureRegion> frames = new Array<TextureRegion>();
        for(int i = 0; i < 2; i++){
            frames.add(new TextureRegion(screen.getAtlas()[3].findRegion("zombie_walk"), i*430,0,430,519));
        }
        return new Animation(0.4f, frames);
    }
}
