package assignment2;

import java.util.ArrayList;

public class MainController
{
    private final MainView view;
    private ArrayList<Movie> modelList = new ArrayList<>();

    public MainController(MainView view)
    {
        this.view = view;
    }
}
