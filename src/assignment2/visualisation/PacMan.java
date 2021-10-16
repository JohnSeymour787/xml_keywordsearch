package assignment2.visualisation;

import java.awt.*;
import javax.swing.*;

/**
 * Pac is the class responsible for drawing a PacMan using Graphics2D
 *
 * @ credit: http://www.fredosaurus.com/notes-java/examples/graphics/face/face2app.html
 */
public class PacMan extends JComponent {
    //====================================================== constants
    private static final int BORDER = 8;  // Border in pixels.
    
    //===================================================== constructor
    public PacMan() {
        this.setPreferredSize(new Dimension(600, 400));  // size
    }
    
    //================================================== paintComponent
    @Override public void paintComponent(Graphics g) {
    	
        int w = getWidth()-200;
        int h = getHeight();
        
        Graphics2D g2 = (Graphics2D) g;
                
        //... Draw the head with open mouth and 8 pixel border
        g2.setColor(Color.PINK);
        g2.fillArc(BORDER, BORDER, w - 2*BORDER, h - 2*BORDER, 30, 300);  
        
        //... Draw the eye
        g2.setColor(Color.MAGENTA);
        int eyeSize = w / 7;
        g2.fillOval(w / 2, h / 5, eyeSize, eyeSize);
        
        g2.setColor(Color.BLACK);
        g2.drawString("2021 COS80007 Advanced Java Assignment 2", 300, 160);
        g2.drawString("John Seymour", 300, 180);
        g2.drawString("Quinn Chan", 300, 200);
        g2.drawString("Zichen Wu", 300, 220);
    }
}