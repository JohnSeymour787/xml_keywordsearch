package assignment2.visualisation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

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
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class VisualController implements XMLController {
	private final VisualView view;
	private File selectedFile = new File("./src/assignment2/imdb.xml");
	Hashtable<String, Integer> tab = new Hashtable<String, Integer>();
	String[] arr = { "mafia", "wedding", "organized-crime", "lawyer", "violence", "new-york-city", "1940s",
			"extramarital-affair", "falling-down-stairs", "thompson-gun" };
	int top = 3;

	class Occurrence implements Comparable<Occurrence> {

		int freq;
		String keyword;

		Occurrence(String keyword, int freq) {
			this.keyword = keyword;
			this.freq = freq;
		}

		public int compareTo(Occurrence e) {
			return this.freq - e.freq;
		}
	}

// Init the element list
	ArrayList<Occurrence> occurs = new ArrayList<Occurrence>();

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
				occurs.add(new Occurrence(arr[i], tab.get(arr[i])));
			}

			// Sort and print
			Collections.sort(occurs);
			Collections.reverse(occurs); // If you want reverse order
			for (Occurrence occ : occurs) {
				System.out.println(occ.keyword + " " + occ.freq);
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
				xAxis.setLabel("Class Name");
				yAxis.setLabel("Class Frequency");

				BarChart<String, Integer> bar = new BarChart(xAxis, yAxis);
				bar.setTitle("Class Frequency Bar Chart");

				XYChart.Series<String, Integer> series = new XYChart.Series<>();

				for (int i = 0; i < top; i++) {
					series.getData().add(new XYChart.Data(occurs.get(i).keyword, occurs.get(i).freq));
				}
				series.setName("Class Frequency");

				bar.getData().add(series);
				Group root = new Group(bar);
				// root.getChildren().add(bar);
				Scene sc = new Scene(root, 500, 400);
				Stage stage1 = new Stage();
				stage1.setTitle("Bar Chart");
				stage1.setScene(sc);
				stage1.show();

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});

		this.view.setPieButtonHandler(event -> {
			try {
				top = (int)this.view.getToggleGroup().getSelectedToggle().getUserData();
				ObservableList<Data> list = FXCollections.observableArrayList();

				for (int i = 0; i < top; i++) {
					list.add(new PieChart.Data(occurs.get(i).keyword, occurs.get(i).freq));
				}

				PieChart pieChart = new PieChart();
				pieChart.setData(list);
				pieChart.setLegendSide(Side.LEFT);
				pieChart.setTitle("Class Frequency Pie Chart");
				pieChart.setClockwise(false);

				Group root = new Group();
				root.getChildren().add(pieChart);
				Scene sc = new Scene(root, 500, 400);
				Stage stage1 = new Stage();
				stage1.setScene(sc);
				stage1.setTitle("Pie Chart");
				stage1.show();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});
	}

	public Node getViewNode() {
		return view.asNode();
	}
}