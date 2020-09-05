package com.k1;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;


 public class Controller {
    Controller(Scene scene, Sound sound, AnimationTimer timer) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case SPACE:
                    Content.bird.jump();
                    break;
                case UP:
                    sound.setVolume(sound.getVolume() + 0.1F);
                    break;
                case DOWN:
                    sound.setVolume(sound.getVolume() - 0.1F);
                    break;
                case P:
                    timer.stop();
                    break;
                case L:
                    timer.start();
                    break;
            }
        });
    }
}
