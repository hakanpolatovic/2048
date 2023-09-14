import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	//github/hakanpolatovic
	//instagram/hakanpolatovic

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	JFrame frame = new JFrame();
	Panel panel = new Panel();
	frame.add(panel);
	frame.setSize(panel.userwidth,panel.userheigth);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	
	panel.run();
	
	}

}
