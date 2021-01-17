package firstPart;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;
import java.awt.*; // Graphics, Shape
import java.awt.geom.*; //Graphics2D

public class ColorButtons implements Icon {

	private int size;
	static Color begin;

	public ColorButtons(int aSize, Color a) {
		size = aSize;
		begin = a;
	}

	public void changeColor(Color a) {
		begin = a;

	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double planet = new Ellipse2D.Double(x, y, size, size);
		g2.setColor(begin);
		g2.fill(planet);
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return size;
	}

}
