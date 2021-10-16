package assignment2.visualisation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

import javax.swing.SwingUtilities;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
//import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import assignment2.XMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.StackPane;
import javafx.scene.chart.XYChart;

/**
 * VisualController is the class responsible for the control part of creating bar and pie charts.
 *
 * @author Quinn Chan 103053395
 * @version JDK 14.0.2 - 22/10/2021
 */

public class VisualController implements XMLController {
	private final VisualView view;
	private File selectedFile = new File("./src/assignment2/imdb.xml");
	Hashtable<String, Integer> tab = new Hashtable<String, Integer>();
	String[] arr = { "mafia", "wedding", "organized-crime", "lawyer", "violence", "new-york-city", "1940s",
			"extramarital-affair", "falling-down-stairs", "thompson-gun" };
	int top = 3;

// Init the element list
	ArrayList<VisualModel> occurs = new ArrayList<VisualModel>();

	public VisualController(VisualView view) {
		this.view = view;
		  	

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder docBuilder = null;
		try {

			docBuilder = factory.newDocumentBuilder();

		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Document doc = docBuilder.parse(selectedFile.getPath());

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("movie");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				org.w3c.dom.Node nNode = nList.item(temp);

				if (nNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					NodeList keywords = eElement.getElementsByTagName("kw");

					for (int count = 0; count < keywords.getLength(); count++) {

						org.w3c.dom.Node nodeKeyword = keywords.item(count);
						if (nodeKeyword.getNodeType() == nodeKeyword.ELEMENT_NODE) {
							Element keyword = (Element) nodeKeyword;
							String key = keyword.getTextContent();
							if (tab.containsKey(key)) {
								tab.replace(key, tab.get(key) + 1);
							} else {
								tab.put(key, 1);
							}

						}
					}

				}
			}

			for (String i : tab.keySet()) {
				System.out.println("key: " + i + " value: " + tab.get(i));
			}

			for (int i = 0; i < arr.length; i++) {
				occurs.add(new VisualModel(arr[i], tab.get(arr[i])));
			}

			// Sort and print
			Collections.sort(occurs);
			Collections.reverse(occurs); // If you want reverse order
			for (VisualModel occ : occurs) {
				System.out.println(occ.getKeyword() + " " + occ.getFreq());
			}

		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		this.view.setBarButtonHandler(event -> {
			try {

				top = (int)this.view.getToggleGroup().getSelectedToggle().getUserData();
				System.out.println(top);
				CategoryAxis xAxis = new CategoryAxis();
				NumberAxis yAxis = new NumberAxis();
				xAxis.setLabel("Keyword");
				yAxis.setLabel("Keyword Frequency");

				BarChart<String, Integer> bar = new BarChart(xAxis, yAxis);
				bar.setTitle("Keyword Frequency Bar Chart");

				XYChart.Series<String, Integer> series = new XYChart.Series<>();

				for (int i = 0; i < top; i++) {
					series.getData().add(new XYChart.Data(occurs.get(i).getKeyword(), occurs.get(i).getFreq()));
				}
				series.setName("Keyword Frequency");

				bar.getData().add(series);
				Group root = new Group(bar);
				this.view.setPane(root);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});

		this.view.setPieButtonHandler(event -> {
			try {
				top = (int)this.view.getToggleGroup().getSelectedToggle().getUserData();
				ObservableList<Data> list = FXCollections.observableArrayList();

				for (int i = 0; i < top; i++) {
					list.add(new PieChart.Data(occurs.get(i).getKeyword(), occurs.get(i).getFreq()));
				}

				PieChart pieChart = new PieChart();
				pieChart.setData(list);
				pieChart.setLegendSide(Side.LEFT);
				pieChart.setTitle("Keyword Frequency Pie Chart");
				pieChart.setClockwise(false);

				Group root = new Group();
				//root.getChildren().add(pieChart);
				//this.view.setPane(root);
				
				final SwingNode swingNode = new SwingNode();
		        createAndSetSwingContent(swingNode);

		        StackPane pane = new StackPane();
		        pane.getChildren().add(swingNode);
		        root.getChildren().add(pane);
		        this.view.setPane(root);
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});
	}
	
	private void createAndSetSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                swingNode.setContent(new PiePie());
            }
        });
    }

	public Node getViewNode() {
		return view.asNode();
	}
}