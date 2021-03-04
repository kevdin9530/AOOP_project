package secondAssignment.SlideShow;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlideShow extends Presenter {
	private JLabel image = new JLabel();
	private int counter = 0;
	private static String[] slideImage = { "test.jpg", "test2.jpg","test1.jpg"};
	private String[] slideText = { "this is a bird", "this is plane","this is java"};

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == getNext()) {
			if (counter < slideText.length - 1) {
				counter++;
				showText(slideText[counter]);
				createCenterComponent();
			}

		}
		if (arg0.getSource() == getPrevious()) {
			if (counter > 0) {
				counter--;
				showText(slideText[counter]);
				createCenterComponent();
			}
		}

	}

	public static void main(String[] arg) {

		SlideShow b = new SlideShow();
		b.run();
		b.showText("this is a bird");
		b.setVisible(true);
	}

	@Override
	public Component createCenterComponent() {
		java.net.URL url = SlideShow.class.getResource(slideImage[counter]);
		ImageIcon sss = new ImageIcon(url);
		Image scaleimg = sss.getImage();
		image.setIcon(sss);
		image.setHorizontalAlignment(JLabel.CENTER);
		add(image, new BorderLayout().CENTER);
		return image;
	}
}
