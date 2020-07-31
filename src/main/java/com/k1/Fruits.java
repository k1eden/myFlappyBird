package com.k1;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Fruits extends Pane {
    Circle fruit;

    public Fruits() {
        fruit = new Circle(5, Color.RED);

        getChildren().add(fruit);
    }
}
