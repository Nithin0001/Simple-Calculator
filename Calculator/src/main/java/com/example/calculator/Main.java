package com.example.calculator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Calculator_layout.fxml")));
        Image icon = new Image(new FileInputStream("/Users/nithinr/IdeaProjects/Calculator/src/main/java/com/example/calculator/Icon/calculator_title_icon.jpg"));
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
