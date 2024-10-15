package com.example.transicion;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Transicion extends Application {
    @Override
    public void start(Stage primaryStage) {

        Circle circle = new Circle(200, 200, 100);
        circle.setFill(null);
        circle.setStroke(Color.BLUE);


        Rectangle rectangle = new Rectangle(20, 20);
        rectangle.setFill(Color.RED);


        PathTransition move = new PathTransition();
        move.setDuration(Duration.millis(4000));
        move.setPath(circle);
        move.setNode(rectangle);
        move.setCycleCount(PathTransition.INDEFINITE);
        move.setAutoReverse(false);
        move.play();


        circle.setOnMousePressed((MouseEvent event) -> {
            move.pause();
        });


        circle.setOnMouseReleased((MouseEvent event) -> {
            move.play();
        });


        Group root = new Group(circle, rectangle);
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("PathTransition Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
