package assignment2.search;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.List;

/**
 * MVC view for the search screen. Contains UI elements for getting the movie titles to search for and to display the
 *  keywords to the user.
 *
 * @author Zichen Wu - 102849551
 */
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
        label = new Label("Please enter one or more movie titles here, multiple movie titles should be separated by \"/\" (e.g title1/title2)");
        inputTextField = new TextField();
        buttonSearch = new Button("Search");
        resultLabel = new Label("Keywords will be displayed here");
        textArea = new TextArea();

        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.addRow(0, label);
        gridPane.addRow(1, inputTextField);
        gridPane.addRow(1, buttonSearch);
        inputTextField.setPrefWidth(widthTextArea);
        inputTextField.setPrefHeight(heightTextArea);
        gridPane.addRow(2, resultLabel);
        gridPane.addRow(3, textArea);
    }

    public Node asNode() { return gridPane; }

    public String getMoviesTitles() { return inputTextField.getText(); }

    public void setTextArea(String str) { textArea.setText(str); }

    public void addSearchBtnListener(EventHandler<ActionEvent> listener) {
         buttonSearch.setOnAction(listener);
    }
}
