package assignment2.search;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

public class SearchView {
    private final GridPane gridPane = new GridPane();
    private final Label label = new Label("!");

    public SearchView() {
        gridPane.addRow(0, label);
    }

    public Node asNode()
    {
        return gridPane;
    }

    public Window getViewWindow()
    {
        return gridPane.getScene().getWindow();
    }


}
