package firstAssignment;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonPaint {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1000, 1000);
		frame.setLayout(new FlowLayout());
		JButton blueButton = new JButton("blue");
		JButton redButton = new JButton("red");
		JButton greenButton = new JButton("green");
		ColorButtons a = new ColorButtons(80, Color.RED);
		JLabel b = new JLabel(a);
		frame.add(b);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		class Listener extends JPanel implements ActionListener {

			public void actionPerformed(ActionEvent event) {
				Color color = null;
				if (event.getSource() == redButton) {
					a.changeColor(Color.RED);

				} else if (event.getSource() == blueButton) {
					a.changeColor(Color.BLUE);
				} else {
					a.changeColor(Color.GREEN);
				}
				frame.getContentPane().repaint();

			}

		}
		greenButton.addActionListener(new Listener());
		redButton.addActionListener(new Listener());
		blueButton.addActionListener(new Listener());
		panel.add(redButton);
		panel.add(greenButton);
		panel.add(blueButton);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}