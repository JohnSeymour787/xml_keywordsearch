package assignment2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * This class acts as the home screen view of the program. The main purpose of this class is to allow for navigation
 *  between the different feature screens required for this assignment. As such, 3 buttons enable this navigation
 *  with a display pane below them on which the feature screen is displayed.
 *
 * @author John Seymour - 101116720
 */
public class MainView
{
    private final VBox view = new VBox();
    private final StackPane screenDisplay = new StackPane();
    private final Button sourceScreenBtn;
    private final Button searchScreenBtn;
    private final Button visualisationScreenBtn;

    public MainView()
    {
        sourceScreenBtn = new Button("Source Screen");
        searchScreenBtn = new Button("Search Screen");
        visualisationScreenBtn = new Button("Visualisation Screen");

        // Button box background
        Rectangle buttonBoxBackground = new Rectangle(Main.SCREEN_WIDTH, 40, Paint.valueOf("#03A9F4"));

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(sourceScreenBtn, searchScreenBtn, visualisationScreenBtn);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(new Insets(7, 3, 3, 3));

        StackPane navigationStackPane = new StackPane(buttonBoxBackground, buttonBox);

        // Creating title label
        Rectangle titleRectangle = new Rectangle();
        titleRectangle.setHeight(35);
        titleRectangle.setWidth(Main.SCREEN_WIDTH);
        titleRectangle.setFill(Paint.valueOf("#FF5252"));
        Label titleLabel = new Label("XML Keyword Search System");
        titleLabel.setStyle("-fx-font: 24 arial;");
        StackPane titleStack = new StackPane();
        titleStack.getChildren().add(titleRectangle);
        titleStack.getChildren().add(titleLabel);

        screenDisplay.setAlignment(Pos.TOP_CENTER);
        view.setAlignment(Pos.TOP_CENTER);
        view.getChildren().add(titleStack);
        view.getChildren().add(navigationStackPane);
        view.getChildren().add(screenDisplay);

        Rectangle screenBackground = new Rectangle();
        screenBackground.setWidth(Main.SCREEN_WIDTH);
        screenBackground.setHeight(Main.SCREEN_HEIGHT);
        screenBackground.setFill(Paint.valueOf("#8bc34a"));
        screenDisplay.getChildren().add(screenBackground);
    }

    public Parent asParent()
    {
        return view;
    }

    /**
     * Clears the screen display pane on the bottom half of this view before adding the new Node in its place.
     * @param newView New node view to display.
     */
    public void updateDisplay(Node newView)
    {
        // Don't want to remove the background box
        if (screenDisplay.getChildren().size() > 1)
        {
            screenDisplay.getChildren().remove(1);
        }
        screenDisplay.getChildren().add(newView);
    }

    public void addSourceScreenListener(EventHandler<ActionEvent> listener)
    {
        sourceScreenBtn.setOnAction(listener);
    }

    public void addSearchScreenListener(EventHandler<ActionEvent> listener)
    {
        searchScreenBtn.setOnAction(listener);
    }

    public void addVisualisationScreenListener(EventHandler<ActionEvent> listener)
    {
        visualisationScreenBtn.setOnAction(listener);
    }
}