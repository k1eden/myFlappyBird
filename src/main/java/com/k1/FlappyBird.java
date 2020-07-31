package com.k1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends Application {
    public static Pane Root1 = new Pane();
    public static Pane Root2 = new Pane();
    public static ArrayList<Walls> walls = new ArrayList<>();
    public static ArrayList<Fruits> fruits = new ArrayList<>();
    public static int score = 0;
    public Label scoreTab = new Label("Score: " + score);
    Birdy bird = new Birdy();

    public Parent cContent() {                                                            //отвечает за создание сцены.
        Root1.setPrefSize(600, 600);

        for (int i = 1; i < 1000; i++) {
            int apertureWidth = (int)(Math.random() * 50 + 100);
            int WallsHeight = new Random().nextInt(600 - apertureWidth);
            Walls wall = new Walls(WallsHeight);
            wall.setTranslateX(i * 300 + 650);
            wall.setTranslateY(0);
            walls.add(wall);

            Walls wall2 = new Walls(600 - apertureWidth - WallsHeight);
            wall2.setTranslateX(i * 300 + 650);
            wall2.setTranslateY(apertureWidth + WallsHeight);
            walls.add(wall2);


            Root1.getChildren().addAll(wall, wall2);
        }

        for (int i = 1; i < 1000; i += 25) {
            Fruits fruit = new Fruits();

            fruit.setTranslateX(15 * i);
            fruit.setTranslateY(Math.random() * 50 + 150);

            fruits.add(fruit);

            Root1.getChildren().addAll(fruit);
        }

        Root1.getChildren().add(bird);
        Root2.getChildren().addAll(Root1, scoreTab);
        return Root2;
    }

    public void refresh() {

        if (bird.movement.getY() < 6) bird.movement = bird.movement.add(0,1);

        bird.moveX((int)bird.movement.getX());
        bird.moveY((int)bird.movement.getY());
        scoreTab.setText("Score: " + score);

        bird.translateXProperty().addListener(((observableValue, number, t1) -> {
            if (t1.intValue() > 170) Root1.setLayoutX(-(t1.intValue() - 170));
        }));
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("FBird");
        stage.getIcons().add(new Image("flappy.png"));
        Scene scene = new Scene(cContent());
        scene.setOnMouseClicked(mouseEvent -> bird.jump());
        scene.setOnKeyPressed(SPACE -> bird.jump());
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                refresh();
            }
        }; timer.start();
    }

    public static void main(String[] args) {launch(args);}
}
