package assignment2.source;

import assignment2.Movie;
import assignment2.XMLController;
import javafx.scene.Node;
import java.util.ArrayList;

public class SourceController implements XMLController
{
    private final SourceView view;
    private final ArrayList<Movie> model;

    public SourceController(SourceView view, ArrayList<Movie> model)
    {
        this.view = view;
        this.model = model;
    }

    public Node getViewNode()
    {
        return view.asNode();
    }
}