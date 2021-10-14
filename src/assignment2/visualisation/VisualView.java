package assignment2.visualisation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

public class VisualView
{
    private final GridPane gridPane = new GridPane();
    private final ToggleGroup group = new ToggleGroup();  
    private final RadioButton button1 = new RadioButton("Top-3 correlated keywords");  
    private final RadioButton button2 = new RadioButton("Top-5 correlated keywords");  
    private final RadioButton button3 = new RadioButton("Top-8 correlated keywords");  
    private final RadioButton button4 = new RadioButton("Top-10 correlated keywords");
    private final Button btnBarChart = new Button("Bar Chart");
    private final Button btnPieChart = new Button("Pie Chart");
    private final VBox root=new VBox();
    
    
    public VisualView()
    {
    	button1.setToggleGroup(group);  
        button2.setToggleGroup(group);  
        button3.setToggleGroup(group);  
        button4.setToggleGroup(group);
        button1.setUserData(3);
        button2.setUserData(5);
        button3.setUserData(8);
        button4.setUserData(10);
          
        root.setSpacing(10);  
        root.getChildren().addAll(button1,button2,button3,button4); 
        button1.setSelected(true);
                
    	btnBarChart.setMinWidth(100);    	
    	btnPieChart.setMinWidth(100);
    	
    	HBox hboxChart = new HBox(10, btnBarChart, btnPieChart);
    	hboxChart.setAlignment(Pos.CENTER); 
    	
    	gridPane.addRow(0,root);
        gridPane.addRow(3, hboxChart);
                
    }

    public Node asNode()
    {
        return gridPane;
    }
    
    public ToggleGroup getToggleGroup() {
    	return group;
    }

    public Window getViewWindow()
    {
        return gridPane.getScene().getWindow();
    }
       
    public void setBarButtonHandler(EventHandler<ActionEvent> handler)
    {
    	btnBarChart.setOnAction(handler);
    }

    public void setPieButtonHandler(EventHandler<ActionEvent> handler)
    {
    	btnPieChart.setOnAction(handler);
    }

    
}