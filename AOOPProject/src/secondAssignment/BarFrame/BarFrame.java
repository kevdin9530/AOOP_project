package secondAssignment.BarFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * A class that implements an Observer object that displays a barchart view of a
 * data model.
 */
public class BarFrame extends JFrame implements ChangeListener, ActionListener, MouseListener {
	/**
	 * Constructs a BarFrame object
	 * 
	 * @param dataModel
	 *            the data that is displayed in the bar chart
	 */
	double max;
	double barHeight;
	double barLength;
	public BarFrame(final DataModel dataModel) {

		this.dataModel = dataModel;
		a = dataModel.getData();

		setLocation(0, 200);
		setLayout(new BorderLayout());
		
		

		Icon barIcon = new Icon() {
			
			public int getIconWidth() {
				return ICON_WIDTH;
			}

			public int getIconHeight() {
				return ICON_HEIGHT;
			}

			public void paintIcon(Component c, Graphics g, int x, int y) {
				Graphics2D g2 = (Graphics2D) g;

				g2.setColor(Color.red);

				max = (a.get(0)).doubleValue();
				for (Double v : a) {
					double val = v.doubleValue();
					if (val > max)
						max = val;
				}

				barHeight = getIconHeight() / a.size();

				int i = 0;
				for (Double v : a) {
					double value = v.doubleValue();

					 barLength = getIconWidth() * value / max;

					Rectangle2D.Double rectangle = new Rectangle2D.Double(0,  barHeight * i, barLength, barHeight);
				
					i++;
					g2.fill(rectangle);
				}
			}
		};
		
		add(new JLabel(barIcon));
		
	addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent event) {
				
				mousePoint = event.getPoint();
				
				for(int i = 0; i< a.size();i++){
					if(mousePoint.getX() < 8 || mousePoint.getX() > 207 ||  mousePoint.getY() < 30 || mousePoint.getY() > 230) 
					{}
					else if(mousePoint.getY() < getInsets().top+barHeight*(i+1) && mousePoint.getY() >getInsets().top+barHeight*i){
					dataModel.update(i,  (((mousePoint.getX()-getInsets().left)/ICON_WIDTH)*max));
				 	;}
				
				}
				
				
				
			}
			
		});
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * Called when the data in the model is changed.
	 * 
	 * @param e
	 *            the event representing the change
	 */
	public void stateChanged(ChangeEvent e) {
		a = dataModel.getData();
		repaint();
	}

	private ArrayList<Double> a;
	private DataModel dataModel;
	private Point mousePoint;

	private static final int ICON_WIDTH = 200;
	private static final int ICON_HEIGHT = 200;

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
