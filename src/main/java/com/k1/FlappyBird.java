package com.k1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class FlappyBird extends Application {

    @Override
    public void start(Stage stage) {
        Sound sound = new Sound(new File("src/main/resources/C418 - Taswell.wav"));
        stage.setTitle("FBird");
        stage.getIcons().add(new Image("flappy.png"));
        Scene scene = new Scene(Content.cContent());
        scene.setOnMouseClicked(mouseEvent -> Content.bird.jump());
        scene.setOnKeyPressed(SPACE -> Content.bird.jump());
        stage.setScene(scene);
        stage.show();
        sound.play();
        sound.setVolume(0.7F);

        if (Content.score + Content.failCounter - Content.helpScore == 10000) {
            stage.close();
            System.out.println("Thank you for game! Your score is: " + Content.score);
        }

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                Content.refresh();
            }
        }; timer.start();
    }

    public static void main(String[] args) {launch(args);}
}
