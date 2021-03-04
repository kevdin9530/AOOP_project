package finalSukobanProject;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

/**
 * A Tictactoe game that uses GameFrameWork to run
 * @author Kevin Hoang Dinh and Johan Hero
 * @version 1.0
 * @since 2019-05-27
 */
public class TTT extends GameFrameWork implements GameInterface  {
	int turn = 1;
	int speed = 130;
	private ImageIcon X = new ImageIcon("X.png"); 
	private ImageIcon O = new ImageIcon("O.png"); 
	private ImageIcon tom = new ImageIcon("tom.png"); 
	private Player player = new Player(10, 45, "pointer.png"); 
	int [][] board = new int[][]{
		{0,0,0},
		{0,0,0},
		{0,0,0}};
	/**
	 * {@inheritDoc} 
	 */
	public void paint(Graphics g) { 
		for(int i = 0; i < board.length; i ++) { 
			for(int j= 0; j < board[0].length; j ++) { 
				if(board[i][j] == 0)  
					g.drawImage(tom.getImage(), i*130, j*130, null); 
				if(board[i][j] == 1)  
					g.drawImage(X.getImage(), i*130, j*130, null); 
				if(board[i][j] == 2)  
					g.drawImage(O.getImage(), i*130, j*130, null); 
			}
		}
		player.drawPlayer(g);
	}
	
	/**
	 *{@inheritDoc}
	 */
	public void move(int x, int y){
		player.setImagePath("pointer.png");
		player.setxAxis(player.getxAxis() + x*speed); 
		player.setyAxis(player.getyAxis() + y*speed); 
		if(player.getxAxis() > 130 * 3){
			player.setxAxis(player.getxAxis() - x*speed); 
		}
		if(player.getyAxis() > 130 * 3){
			player.setyAxis(player.getyAxis() - y*speed); 
		}
		if(player.getxAxis() < 0){
			player.setxAxis(player.getxAxis() - x*speed); 
		}
		if(player.getyAxis() < 0 ){
			player.setyAxis(player.getyAxis() - y*speed); 
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void youWin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void youLost() {
		
		
	}
	
	/**
	 * *{@inheritDoc}
	 */
	@Override
	public void init() {
		setPanelSize(140*3,140*3);		
	}
	/**
	 * Move the arrow left
	 */
	@Override
	public void left() {
		move(-1,0);	
	}
	/**
	 * Move the arrow right
	 */
	@Override
	public void right() {
		move(1,0);	
	}

	/**
	 * Move the arrow up
	 */
	@Override
	public void up() {
		move(0,-1);	
	}

	/**
	 * Move the arrow down
	 */
	@Override
	public void down() {
		move(0,1);		
	}
	/**
	 * Set X or O on arrow position
	 */
	@Override
	public void space() {
		if(turn == 1){
		board[(player.getxAxis()-10)/130][(player.getyAxis()-45)/130] = turn;
		turn++;	
		}
		else if(turn == 2){
		board[(player.getxAxis()-10)/130][(player.getyAxis()-45)/130] = turn;
		turn--;
		}
		repaint();
	}
	

	@Override
	public void timerAction() {
		// TODO Auto-generated method stub
	}
}
