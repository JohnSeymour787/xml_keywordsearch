package assignment2;

import assignment2.search.SearchController;
import assignment2.search.SearchView;
import assignment2.source.SourceController;
import assignment2.source.SourceView;
import assignment2.visualisation.VisualController;
import assignment2.visualisation.VisualView;

import java.util.ArrayList;
import java.util.List;

public class MainController
{
    private final ArrayList<Movie> modelList = new ArrayList<>();
    private final List<String> keywordsList = new ArrayList<>();
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
            currentController = new SearchController(new SearchView(), modelList, keywordsList);
            view.updateDisplay(currentController.getViewNode());
        });

        view.addVisualisationScreenListener(event ->
        {
            // TODO() Create source screen view and update currentController, pass the controller the modelList, call view.updateDisplay
        	currentController = new VisualController(new VisualView());
        	view.updateDisplay(currentController.getViewNode());
        	//view.updateDisplay(new Label("Visualisation"));
        });
    }
}