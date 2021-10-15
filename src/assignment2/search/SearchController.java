package assignment2.search;

import assignment2.XMLController;
import assignment2.source.SourceController;
import javafx.scene.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchController implements XMLController {
    private final SearchView view;
    private final SearchModel model;

    public SearchController(SearchView view, SearchModel model) {
        this.view = view;
        this.model = model;

        this.view.addSearchBtnListener(e -> {
            List<String> list = new ArrayList<>();
            String moviesTitles = this.view.getMoviesTitles();
            list = this.model.searchKeywords(moviesTitles);
        });

    }

    public Node getViewNode()
    {
        return view.asNode();
    }

}
