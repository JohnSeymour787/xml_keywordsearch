package assignment2.search;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SearchView {
    private final GridPane gridPane;
    private final Label label;
    private final TextField inputTextField;
    private double widthTextArea = 50;
    private double heightTextArea = 15;
    private final Button buttonSearch;
    private final Label resultLabel;
    private final TextArea textArea;

    public SearchView() {
        gridPane = new GridPane();
        label = new Label("Please enter a keyword to search the movie.");
        inputTextField = new TextField();
        buttonSearch = new Button("Search");
        resultLabel = new Label("the result of searching keyword will be displayed here");
        textArea = new TextArea();

        gridPane.addRow(0, label);
        gridPane.addRow(1, inputTextField);
        gridPane.addRow(1, buttonSearch);
        inputTextField.setPrefWidth(widthTextArea);
        inputTextField.setPrefHeight(heightTextArea);
        gridPane.addRow(2, resultLabel);
        gridPane.addRow(3, textArea);
    }

    public Node asNode()
    {
        return gridPane;
    }

}
