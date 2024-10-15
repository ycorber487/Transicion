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

        Circle circle = new Circle(200, 200, 100); // creamos un circulo
        circle.setFill(null); // vacio
        circle.setStroke(Color.BLUE); //borde azul


        Rectangle rectangle = new Rectangle(20, 30); //creamos un rectangulo 
        rectangle.setFill(Color.RED); //le damos color rojo


        PathTransition move = new PathTransition(); // creamos una transicion
        move.setDuration(Duration.millis(4000));
        move.setPath(circle);
        move.setNode(rectangle);
        move.setCycleCount(PathTransition.INDEFINITE);
        move.setAutoReverse(false);
        move.play();


        circle.setOnMousePressed((MouseEvent event) -> { // evento pausa
            move.pause();
        });


        circle.setOnMouseReleased((MouseEvent event) -> { //evento actuar
            move.play();
        });


        Group root = new Group(circle, rectangle); // metemos ambas figuras en un grupo 
        Scene scene = new Scene(root, 400, 400); // introducimos en la escena el grupo y definimos el tamanio

        primaryStage.setTitle("PathTransition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
