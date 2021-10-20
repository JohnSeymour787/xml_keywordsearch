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