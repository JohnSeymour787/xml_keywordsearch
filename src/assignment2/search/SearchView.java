package assignment2.search;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SearchView {
    private final GridPane gridPane;
    private final Label label;
    private final TextField inputTextField;
    private double widthTextArea = 50;
    private double heightTextArea = 15;
    private final Button buttonEnter;
    private final Label resultLabel;

    public SearchView() {
        gridPane = new GridPane();
        label = new Label("Please enter a keyword to search the movie.");
        inputTextField = new TextField();
        buttonEnter = new Button("Search");
        resultLabel = new Label("the result of searching keyword will be displayed here");

        gridPane.addRow(0, label);
        gridPane.addRow(1, inputTextField);
        gridPane.addRow(1, buttonEnter);
        inputTextField.setPrefWidth(widthTextArea);
        inputTextField.setPrefHeight(heightTextArea);
        gridPane.addRow(2, resultLabel);
    }

    public Node asNode()
    {
        return gridPane;
    }

}
