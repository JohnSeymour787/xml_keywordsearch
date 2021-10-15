package assignment2.search;

import assignment2.XMLController;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class SearchController implements XMLController {
    private final SearchView view;
    private final SearchModel model;

    public SearchController(SearchView view, SearchModel model) {
        this.view = view;
        this.model = model;

        try {
            this.view.addSearchBtnListener(e -> {
                List<String> keywordsListMovies = new ArrayList<>();
                String inputString = this.view.getMoviesTitles();
                String[] inputTitles = splitInputTitle(inputString);
                for (String title : inputTitles) {
                    List<String> l = this.model.searchKeywords(title);
                    String lines[] = l.get(0).split("\\r?\\n");
                    List<String> li = new ArrayList<>();
                    for (int i = 1; i < lines.length; i++) {
                        li.add(lines[i]);
                    }
                    keywordsListMovies.addAll(li);
                }
                this.view.setTextArea(keywordsListMovies);
            });
        } catch (Exception e) {
            System.out.println("!!!!!");
        }
    }

    private String[] splitInputTitle(String inputString) {
        String[] inputTitles = inputString.split("/");
        return inputTitles;
    }

    public Node getViewNode()
    {
        return view.asNode();
    }

}
