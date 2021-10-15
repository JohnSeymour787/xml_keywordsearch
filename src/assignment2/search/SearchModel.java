package assignment2.search;

import com.sun.org.apache.xml.internal.resolver.readers.SAXCatalogReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.*;

public class SearchModel {

    //the string will be replaced with an array that contains more titles later
    public List<String> searchKeywords(String inputMovieTitle) {
        List<String> keywordsList = new ArrayList<>();

        try {
            File inputFile = new File("imdb.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList movieList = doc.getElementsByTagName("movie");

            for (int i = 0; i < movieList.getLength(); i++) {
                Node movieNode = movieList.item(i);

                if (movieNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element movie = (Element) movieNode;
                    NodeList childrenList = movie.getChildNodes();

                    for (int j = 0; j < childrenList.getLength(); j++) {
                        Node childNodeOne = childrenList.item(j);

                        if (childNodeOne.getNodeName().equalsIgnoreCase("title")) {
                            String movieTitle = childNodeOne.getTextContent();

                            if (movieTitle.equalsIgnoreCase(inputMovieTitle)) {

                                for (int k = 0; k < childrenList.getLength(); k++) {
                                    Node childNodeTwo =  childrenList.item(k);

                                    if (childNodeTwo.getNodeName().equalsIgnoreCase("kws")) {
                                        //System.out.println(childNodeTwo.getTextContent());
                                        String keyword = childNodeTwo.getTextContent();
                                        keywordsList.add(keyword);
                                    }
                                }
                            }
                        }
                    }

                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return keywordsList;
    }
}
