package assignment2.source;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SourceView
{
    private final GridPane gridPane = new GridPane();

    public SourceView()
    {
        gridPane.addRow(0, new Label("This is a label"));
    }

    public Node asNode()
    {
        return gridPane;
    }
}