package assignment2.source;

import assignment2.Movie;
import assignment2.XMLController;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * MVC controller class for the Source Screen component of the program. Responsible for handling button
 *  clicks from the SourceView and manipulating the Movie array model.
 *
 * @author John Seymour - 101116720
 */
public class SourceController implements XMLController
{
    private final SourceView view;
    private final ArrayList<Movie> model;
    private File selectedFile;

    public SourceController(SourceView view, ArrayList<Movie> model)
    {
        this.view = view;
        this.model = model;

        this.view.setSourceButtonHandler(event ->
        {
            FileChooser chooser= new FileChooser();
            chooser.setTitle("Open File");
            selectedFile = chooser.showOpenDialog(view.getViewWindow());
        });

        this.view.setLoadButtonHandler(event ->
        {
            // If loading multiple times, need to clear the list first
            model.clear();

            try
            {
                SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

                MovieHandler handler = new MovieHandler(this.model);
                saxParser.parse(selectedFile, handler);

                displayMovies();
            }
            catch (ParserConfigurationException | SAXException | IOException e) { e.printStackTrace(); }
        });
    }

    /**
     * Displays all movies in the movie array onto the view's text field.
     */
    private void displayMovies()
    {
        for (int i = 0; i < model.size(); i++)
        {
            view.appendTextField(model.get(i).toString());
            view.appendTextField("---------------");

            if (i < model.size() - 1)
            {
                view.appendTextField("\r\n");
            }
        }
    }

    public Node getViewNode()
    {
        return view.asNode();
    }
}