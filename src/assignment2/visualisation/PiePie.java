package assignment2.visualisation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * PiePie is the class responsible for drawing the pie chart using graphics2d.
 *
 * @author Quinn Chan - 103053395
 * @version JDK 14.0.2 - 22/10/2021
 * @credits :https://stackoverflow.com/questions/13662984/creating-pie-charts-programmatically
 */

class Slice {
	double value;
	Color color;
	String key;

	public Slice (String key, double value, Color color) {
		this.value = value;
		this.color = color;
		this.key = key;
	}
}

public class PiePie extends JComponent {

	private ArrayList<VisualModel> occurs = new ArrayList<VisualModel>();
	private ArrayList<Slice> slices = new ArrayList<Slice>();
	private Color[] colors = { Color.black, Color.magenta, Color.red, Color.orange, Color.yellow, Color.green, Color.gray,
			Color.blue, Color.cyan, Color.pink };
	// public PiePie() {}

	public PiePie(ArrayList<VisualModel> occurs) {
		this.setPreferredSize(new Dimension(500, 300)); // size
		this.occurs = occurs;
		for (int i = 0; i<occurs.size(); i++) {
			this.slices.add(new Slice(occurs.get(i).getKeyword(), occurs.get(i).getFreq(), colors[i]));
		}
	}


	@Override
   public void paintComponent(Graphics g) {
      drawPie((Graphics2D) g, getBounds(), slices);
   }

	void drawPie(Graphics2D g, Rectangle area, ArrayList<Slice> slices) {
		double total = 0.0D;
		for (int i = 0; i < slices.size(); i++) {
			total += slices.get(i).value;
		}
		double curValue = 0.0D;
		int startAngle = 0;
		for (int i = 0; i < slices.size(); i++) {
			startAngle = (int) (curValue * 360 / total);
			int arcAngle = (int) (slices.get(i).value * 360 / total);
			g.setColor(slices.get(i).color);
			g.fillArc(area.x, area.y, area.width-200, area.height, startAngle, arcAngle);
			curValue += slices.get(i).value;
			g.drawString(slices.get(i).key, 350, i*20+40);
		}
	}

}
