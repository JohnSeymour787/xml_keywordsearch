package assignment2.search;

import assignment2.XMLController;
import assignment2.source.SourceController;
import javafx.scene.Node;

import java.io.File;

public class SearchController implements XMLController {
    private final SearchView view;
    private File inputFile;

    public SearchController(SearchView view) {
        this.view = view;
        this.inputFile = new File("imdb.xml");

        this.view.addSearchBtnListener(e -> {
            
        });

    }

    public Node getViewNode()
    {
        return view.asNode();
    }

}
