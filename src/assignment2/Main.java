package assignment2;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javax.swing.*;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{
    public static final double SCREEN_WIDTH = 700;
    public static final double SCREEN_HEIGHT = 510;

    @Override
    public void start(Stage primaryStage)
    {
    	final SwingNode swingNode = new SwingNode();
        createAndSetSwingContent(swingNode);

        StackPane pane = new StackPane();
        pane.getChildren().add(swingNode);
    	
    	MainView mainView = new MainView();
    	mainView.updateDisplay(pane);
        new MainController(mainView);
        Scene scene = new Scene(mainView.asParent(), SCREEN_WIDTH, SCREEN_HEIGHT);
        primaryStage.setTitle("XML Keyword Search System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void createAndSetSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(() -> swingNode.setContent(new PacMan()));
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}