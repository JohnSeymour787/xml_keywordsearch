package assignment2.search;

import assignment2.Movie;
import assignment2.XMLController;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class SearchController implements XMLController {
    private final SearchView view;
    private final ArrayList<Movie> movieList;

    public SearchController(SearchView view, ArrayList<Movie> movieList) {
        this.view = view;
        this.movieList = movieList;

        this.view.addSearchBtnListener(e -> {
            List<String> keywordsList = new ArrayList<>();
            String inputString = this.view.getMoviesTitles();
            String[] inputTitles = splitInputTitle(inputString);
            String strOutput = searchMovies(movieList, inputTitles, keywordsList);
            this.view.setTextArea(strOutput);
        });
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
