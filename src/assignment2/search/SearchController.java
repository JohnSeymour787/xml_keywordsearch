package assignment2.search;

import assignment2.XMLController;
import javafx.scene.Node;

public class SearchController implements XMLController {
    private final SearchView view;

    public SearchController(SearchView view) {
        this.view = view;
    }

    public Node getViewNode()
    {
        return view.asNode();
    }
}
