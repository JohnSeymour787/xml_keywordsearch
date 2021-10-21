package assignment2.source;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
        HBox buttonRow = new HBox(chooseSourceButton, loadSourceButton);
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.setSpacing(50);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.addRow(0, buttonRow);
        gridPane.addRow(1, textArea);
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

    public void scrollTextAreaToTop()
    {
        textArea.setScrollTop(Double.MAX_VALUE);
    }
}