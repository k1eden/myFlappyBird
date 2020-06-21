package com.k1;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;




public class Birdy extends Pane {
    public Point2D movement;
    Rectangle bird;
    public Birdy() {
        Image image = new Image("https://img1.freepng.ru/20180417/aiq/kisspng-flappy-bird-tap-bird-2d-basic-flappy-angry-birds-5ad5bd98c0bcd2.8287977415239571447895.jpg");
        movement = new Point2D(0,0);
        bird = new Rectangle(20, 20, Color.RED);
        bird.setFill(new ImagePattern(image));
        setTranslateX(120);
        setTranslateY(300);
        getChildren().addAll(bird);
    }

    public void moveY(int dist) {
        for (int i = 0; i < Math.abs(dist); i++) {
            for (Walls wall : FlappyBird.walls) {
                if (wall.getBoundsInParent().intersects(getBoundsInParent())) {
                    FlappyBird.score = 0;
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
            for (Fruits fruit : FlappyBird.fruits) {
                if (fruit.getBoundsInParent().intersects(getBoundsInParent())) {
                    FlappyBird.score += 5;
                    FlappyBird.fruits.remove(fruit);
                    movement = new Point2D(0,2);
                    FlappyBird.Root1.getChildren().remove(fruit);
                }
            }
        }
    }

    public void moveX(int dist) {
        for (int i = 0; i < dist; i++) {
            for (Walls wall : FlappyBird.walls) {
                if (getBoundsInParent().intersects(wall.getBoundsInParent())) {
                    FlappyBird.score = 0;
                    if (getTranslateX() + 20 == wall.getTranslateX()) {
                        setTranslateX(getTranslateX() - 1);
                        return;
                    }
                }
                if (getTranslateX() + 20 == wall.getTranslateX()) FlappyBird.score += 5;
            }
            setTranslateX(getTranslateX() + 1);
        }

        for (int j = 0; j < Math.abs(dist); j++) {
            for (Fruits fruit : FlappyBird.fruits) {
                if (fruit.getBoundsInParent().intersects(getBoundsInParent())) {
                    FlappyBird.score += 5;
                    FlappyBird.fruits.remove(fruit);
                    movement = new Point2D(0,2);
                    FlappyBird.Root1.getChildren().remove(fruit);
                }
            }
        }
    }

    public void jump() {
        movement = new Point2D(2, -12);
    }
}
