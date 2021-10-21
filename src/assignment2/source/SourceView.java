package assignment2.source;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

/**
 * MVC view class for the Source Screen component. Contains the UI elements for this screen only.
 *
 * @author John Seymour - 101116720
 */
public class SourceView
{
    private final GridPane gridPane = new GridPane();
    private final Button chooseSourceButton = new Button("Choose Source");
    private final Button loadSourceButton = new Button("Load");
    private final TextArea textArea = new TextArea();

    public SourceView()
    {
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.addRow(0, chooseSourceButton);
        gridPane.addRow(1, loadSourceButton);
        gridPane.addRow(2, textArea);
    }

    public Node asNode()
    {
        return gridPane;
    }

    public Window getViewWindow()
    {
        return gridPane.getScene().getWindow();
    }

    public void setSourceButtonHandler(EventHandler<ActionEvent> handler)
    {
        chooseSourceButton.setOnAction(handler);
    }

    public void setLoadButtonHandler(EventHandler<ActionEvent> handler)
    {
        loadSourceButton.setOnAction(handler);
    }

    public void appendTextField(String toAppend)
    {
        textArea.appendText(toAppend + "\r\n");
    }
}