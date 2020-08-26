package com.k1;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;



public class Birdy extends Pane {
    public Point2D movement;
    Rectangle bird = new Rectangle(20,20);
    public Birdy() {
        movement = new Point2D(0,0);
        bird.setFill(new ImagePattern(new Image("Fbird.jpg")));
        setTranslateX(120);
        setTranslateY(300);
        getChildren().addAll(bird);
    }

    private void wound() {
        bird.setFill(new ImagePattern(new Image("FbirdWounded.jpg")));
    }

    private void nullifier() {
        Content.failCounter += 0.1;
    }

    public void moveY(int dist) {
        for (int i = 0; i < Math.abs(dist); i++) {
            for (Walls wall : Content.walls) {
                if (wall.getBoundsInParent().intersects(getBoundsInParent())) {
                    nullifier();
                    wound();
                    if (dist>0) {
                        setTranslateY(getTranslateY() - 1);
                    }
                    else {
                        setTranslateY(getTranslateY() + 1);
                    }
                    return;
                }
            }
            if (getTranslateY() < 0) setTranslateY(0);
            if (getTranslateY() > 580) setTranslateY(580);
            setTranslateY(getTranslateY() + (dist>0? 1:-1));
        }

        for (int j = 0; j < Math.abs(dist); j++) {
            for (Fruits fruit : Content.fruits) {
                if (fruit.getBoundsInParent().intersects(getBoundsInParent())) {
                    Content.score += 5;
                    fruit.setTranslateY(-100);
                    movement = new Point2D(0,2);
                }
            }
        }
    }

    public void moveX(int dist) {
        for (int i = 0; i < dist; i++) {
            for (Walls wall : Content.walls) {
                if (getBoundsInParent().intersects(wall.getBoundsInParent())) {
                    nullifier();
                    wound();
                    if (getTranslateX() + 20 == wall.getTranslateX()) {
                        setTranslateX(getTranslateX() - 1);
                        return;
                    }
                }
                if (getTranslateX() - 20 == wall.getTranslateX()) Content.score += 5;
            }
            setTranslateX(getTranslateX() + 1);
        }

        for (int j = 0; j < Math.abs(dist); j++) {
            for (Fruits fruit : Content.fruits) {
                if (fruit.getBoundsInParent().intersects(getBoundsInParent())) {
                    Content.score += 5;
                    fruit.setTranslateY(-100);
                    movement = new Point2D(0,2);
                }
            }
        }
    }

    public void jump() {
        movement = new Point2D(2, -12);
    }
}
