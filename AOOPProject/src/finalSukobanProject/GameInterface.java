package finalSukobanProject;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
/**
 * An interface class that help game developers/users to make a game easier. 
 * @author Kevin Hoang Dinh and Johan Hero
 * @version 1.0
 * @since 2019-05-27
 */
public interface GameInterface {
	/**
	 * Method to reset the game
	 */
  public void reset();
  /**
   * Method to paint the game.
   * @param g The Graphics context in which to paint
   */
  public void paint(Graphics g);
  /**
   * Method to move item inside the game
   * @param x Move in x axis
   * @param y Move in y axis
   */
  public void move(int x,int y);
  /**
   * Method to know the condition to win
   */
  public void youWin();
  /**
   * Method to know the condition to lose
   */
  public void youLost();
}
