package secondAssignment.SlideShow;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Presenter extends JFrame implements ActionListener {
	private JPanel panel = new JPanel();
	private JButton next, previous;
	private JLabel slideText = new JLabel(); 
	
	
	public abstract java.awt.Component createCenterComponent();
	
	public void showText(String text){
		slideText.setHorizontalAlignment(JLabel.CENTER);
		slideText.setFont(new Font("Courier", Font.BOLD,75));
		this.add(slideText,new BorderLayout().SOUTH);
		slideText.setText(text);
	}

	public void nextButtonPressed(){
		next = new JButton("NEXT");
		panel.add(next);
		this.add(panel, new BorderLayout().NORTH);
		next.addActionListener(this);
	}

	public void previousButtonPressed(){
		previous = new JButton("Previous");
		panel.add(previous);
		this.add(panel, new BorderLayout().NORTH);
		previous.addActionListener(this);

	}
	
	
	/*
	 * Framework method to create a BorderLayout frame with chosen type Center.
	 * With next and previous button already initiate. 
	 */
	public void run(){
		setLayout(new BorderLayout());
		previousButtonPressed();
		nextButtonPressed();
		add(createCenterComponent(),new BorderLayout().CENTER);
		pack();
		
	}
	
	public JButton getNext(){
		return next;
	}
	
	public JButton getPrevious(){
		return previous;
	}
	

	public abstract void actionPerformed(ActionEvent arg0);
}
