package assignment2;

import assignment2.source.SourceController;
import assignment2.source.SourceView;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class MainController
{
    private final ArrayList<Movie> modelList = new ArrayList<>();
    private XMLController currentController;

    public MainController(MainView view)
    {
        view.addSourceScreenListener(event ->
        {
            currentController = new SourceController(new SourceView(), modelList);
            view.updateDisplay(currentController.getViewNode());
            // TODO() Create source screen view and update currentController, pass the controller the modelList, call view.updateDisplay
        });

        view.addSearchScreenListener(event ->
        {
            // TODO() Create source screen view and update currentController, pass the controller the modelList, call view.updateDisplay
            view.updateDisplay(new Label("Search"));
        });

        view.addVisualisationScreenListener(event ->
        {
            // TODO() Create source screen view and update currentController, pass the controller the modelList, call view.updateDisplay
            view.updateDisplay(new Label("Visualisation"));
        });
    }
}