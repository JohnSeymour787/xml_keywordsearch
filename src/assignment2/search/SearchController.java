package assignment2.search;

import assignment2.Movie;
import assignment2.XMLController;
import javafx.scene.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * MVC controller for the search screen. Responsible for searching for movies by title and getting their
 *  keywords.
 *
 * @author Zichen Wu - 102849551
 */
public class SearchController implements XMLController {
    private final SearchView view;
    private final ArrayList<Movie> movieList;
    private final List<String> keywordsList;

    public SearchController(SearchView view, ArrayList<Movie> movieList, List<String> keywordsList) {
        this.view = view;
        this.movieList = movieList;
        this.keywordsList = keywordsList;

        this.view.addSearchBtnListener(e -> {
            keywordsList.clear();
            String inputString = this.view.getMoviesTitles();
            String[] inputTitles = splitInputTitle(inputString);
            String strOutput = searchMovies(movieList, inputTitles, keywordsList);
            this.view.setTextArea(strOutput);
        });

        // If there are already keywords when the controller is loaded, display them
        if (!this.keywordsList.isEmpty())
        {
            String output = "";
            for (String keyword : this.keywordsList) {
                output += keyword + "\r\n";
            }
            this.view.setTextArea(output);
        }
    }

    private String[] splitInputTitle(String inputString) {
        String[] inputTitles = inputString.split("/");
        return inputTitles;
    }

    private String searchMovies(ArrayList<Movie> movieList, String[] inputTitles, List<String> keywordsList) {
        String output = "";
        for (Movie movie : movieList) {
            String movieTitle = movie.getTitle();
            for (String str : inputTitles) {
                if (str.equalsIgnoreCase(movieTitle)) {
                    keywordsList.addAll(movie.getKeywords());
                    for (String keyword : movie.getKeywords()) {
                        output += keyword + "\r\n";
                    }
                }
            }
        }
        return output;
    }

    public Node getViewNode()
    {
        return view.asNode();
    }

}
