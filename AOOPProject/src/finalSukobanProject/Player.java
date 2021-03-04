package finalSukobanProject;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 * A object class for player using in Sokoban and Tictactoe
 * @author Kevin Hoang Dinh and Johan Hero
 * @version 1.0
 * @since 2019-05-27
 */
 public class Player {
	private int xAxis;
	private int yAxis;
	private String imagePath;

	/**
	 * Construction to get player's image, X and Y coordinate of player
	 * @param xAxis Show where player in X axis
	 * @param yAxis Show where player in Y axis
	 * @param imagePath Link to the picture of player
	 */
	public Player(int xAxis, int yAxis, String imagePath) {
		this.setImagePath(imagePath);
		this.setxAxis(xAxis);
		this.setyAxis(yAxis);
	}

	/**
	 * Get array row in a 2D-array according to player's X coordinate 
	 * @return Array row of the player's position
	 */
	public int getX(){
		return xAxis/32;
	}
	
	/**
	 * Get array column in a 2D-array according to player's Y coordinate
	 * @return Array column of player's position
	 */
	public int getY(){
		return yAxis/32;
	}
	
	/**
	 * Get X coordinate of the player
	 * @return X coordinate of player's position
	 */
	public int getxAxis() {
		return xAxis;
	}
	/**
	 * Set X coordinate to the player
	 * @param xAxis X coordinate to set for the player
	 */
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	/**
	 * Get Y coordinate of the player
	 * @return Y coordinate of player's position
	 */
	public int getyAxis() {
		return yAxis;
	}
	/**
	 * Set Y coordinate to the player
	 * @param yAxis Y coordinate to set for the player
	 */
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	/**
	 * Get the link of player's image
	 * @return Source/path of player's image
	 */
	public String getImagePath() {
		return imagePath;
	}
	
	/**
	 * Set a image to player
	 * @param imagePath Source/path of the image to set on the player
	 */
	public void setImagePath(String imagePath) {
		if(imagePath == null) {
			JOptionPane.showMessageDialog(null, "Invalid string!");
		}
		else if(imagePath.length()==0) {
			JOptionPane.showMessageDialog(null, "String is empty");
		}
		else {
		this.imagePath = imagePath;
		}
	}
	
	/**
	 * Draw up player according to image, X and Y coordinate
	 * @param g the Graphics context in which to paint
	 */
	public void drawPlayer(Graphics g) {
		
		ImageIcon img = new ImageIcon(imagePath);
		g.drawImage(img.getImage(), xAxis, yAxis, null);
	}

}
