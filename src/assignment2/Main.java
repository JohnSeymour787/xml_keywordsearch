package assignment2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        MainView mainView = new MainView();
        new MainController(mainView);

        Scene scene = new Scene(mainView.asParent(), 700, 500, Color.GREEN);

        primaryStage.setTitle("XML Keyword Search System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}