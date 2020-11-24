package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Proyecto integrador");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(root, 1200, 600));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

}
