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
            try
            {
                SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

                MovieHandler handler = new MovieHandler(this.model);
                saxParser.parse(selectedFile, handler);

            }
            catch (ParserConfigurationException | SAXException | IOException e) { e.printStackTrace(); }
        });
    }

    public Node getViewNode()
    {
        return view.asNode();
    }
}