package assignment2;

import assignment2.search.SearchController;
import assignment2.search.SearchView;
import assignment2.source.SourceController;
import assignment2.source.SourceView;
import assignment2.visualisation.VisualController;
import assignment2.visualisation.VisualView;

import java.util.ArrayList;
import java.util.List;

/**
 * MVC controller class for the main component. Responsible for creating other screens and their controllers
 *  and enabling communication of the models between them.
 *
 * @author John Seymour - 101116720
 */
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
        });

        view.addSearchScreenListener(event ->
        {
            currentController = new SearchController(new SearchView(), modelList, keywordsList);
            view.updateDisplay(currentController.getViewNode());
        });

        view.addVisualisationScreenListener(event ->
        {
            currentController = new VisualController(new VisualView(), keywordsList);
        	view.updateDisplay(currentController.getViewNode());
        });
    }
}