package com.k1;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class Walls extends Pane {
    Rectangle wall;
    int h;

    public Walls(int h) {
        this.h = h;
        wall = new Rectangle(25, h, Color.GREEN);

        getChildren().add(wall);
    }
}
