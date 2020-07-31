package com.k1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;



public class Walls extends Pane {
    // Image image = new Image("https://es.toppng.com/public/uploads/thumbnail/flappy-bird-pipe-transparent-11549930651arxp9eyzqz.png");
    Rectangle wall;
    public int h;

    public Walls(int h) {
        this.h = h;
        wall = new Rectangle(25, h, Color.GREEN);
        // wall.setFill(new ImagePattern(image));

        getChildren().add(wall);
    }
}
