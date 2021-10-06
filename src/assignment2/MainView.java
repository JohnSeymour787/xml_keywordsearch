package assignment2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView
{
    private final VBox view = new VBox();
    private final HBox buttonBox = new HBox();
    private final Pane screenDisplay = new Pane();
    private Button sourceScreenBtn;
    private Button searchScreenBtn;
    private Button visualisationScreenBtn;

    public MainView()
    {
        sourceScreenBtn = new Button("Source Screen");
        searchScreenBtn = new Button("Search Screen");
        visualisationScreenBtn = new Button("Visualisation Screen");

        buttonBox.getChildren().addAll(sourceScreenBtn, searchScreenBtn, visualisationScreenBtn);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(new Insets(7, 3, 3, 3));

        view.setAlignment(Pos.TOP_CENTER);
        view.getChildren().add(buttonBox);
        view.getChildren().add(screenDisplay);
    }

    public Parent asParent()
    {
        return view;
    }
}