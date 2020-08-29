package com.k1;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public class Content {
   static Pane Root1 = new Pane();
   static Pane Root2 = new Pane();
   static ArrayList<Walls> walls = new ArrayList<>();
   static ArrayList<Fruits> fruits = new ArrayList<>();
   static int score = 0;
   static double failCounter = 0;
   static Label scoreTab = new Label("Score: " + score);
   static Label failCounterTab = new Label("Fails count: " + failCounter);
   static Birdy bird = new Birdy();
   static int helpScore = 0;

    public static Parent cContent() {
        Root1.setPrefSize(600, 600);
        failCounterTab.setTranslateX(400);

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
        Root2.getChildren().addAll(Root1, scoreTab, failCounterTab);
        return Root2;
    }

    public static void refresh() {
       int score1 = score - (int) failCounter;

        if (bird.movement.getY() < 6) bird.movement = bird.movement.add(0,1);

        bird.moveX((int)bird.movement.getX());
        bird.moveY((int)bird.movement.getY());
        scoreTab.setText("Score: " + score1);
        failCounterTab.setText("Fails count: " + failCounter);

        bird.translateXProperty().addListener(((observableValue, number, t1) -> {
            if (t1.intValue() > 170) Root1.setLayoutX(-(t1.intValue() - 170));
        }));
    }
}
