package com.k1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FlappyBird extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("FBird");
        stage.getIcons().add(new Image("flappy.png"));
        Scene scene = new Scene(Content.cContent());
        scene.setOnMouseClicked(mouseEvent -> Content.bird.jump());
        scene.setOnKeyPressed(SPACE -> Content.bird.jump());
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                Content.refresh();
            }
        }; timer.start();
    }

    public static void main(String[] args) {launch(args);}
}
