package finalSukobanProject;

import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*; 
 /**
  * A Sokoban game that uses GameFrameWork to run. 
  * @author Kevin Hoang Dinh and Johan Hero
  * @version 1.0
  * @since 2019-05-27
  */
public class Sokoban extends GameFrameWork implements GameInterface  { 
	private ImageIcon wall = new ImageIcon("wall.png"); 
	private ImageIcon crate = new ImageIcon("crate.png"); 
	private ImageIcon blank = new ImageIcon("blank.png"); 
	private ImageIcon blankM = new ImageIcon("blankmarked.png"); 
	private ImageIcon crateM = new ImageIcon("cratemarked.png"); 
	private Player player = new Player( 32, 32, "player.png"); 
	private int speed = 32; 
	private boolean canMove = true;
	private int goal ;
	private int winner ; 
	int[][] map = new int[][]{ 
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		  { 0, 3, 2, 1, 1, 1, 1, 1, 1, 0 }, 
		  { 0, 2, 1, 1, 2, 1, 1, 1, 1, 0 }, 
		  { 0, 1, 1, 1, 3, 2, 1, 1, 1, 0 }, 
		  { 0, 1, 1, 1, 2, 3, 3, 2, 1, 0 }, 
		  { 0, 2, 1, 1, 3, 1, 1, 1, 4, 0 }, 
		  { 0, 2, 2, 1, 1, 1, 1, 2, 2, 0 }, 
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
		}; 
		
	 
	/**
	 * Method to initalize all variable, start music, set timer and panel size.
	 */
	public void init(){
		setPanelSize((map.length+1)*32,(map[0].length+1)*32);
		goal =  goalCounter(map);
		winner = pointCounter(map);
		playWav("Mario.wav");
		startTimer(10);
	}
	
	/**
	 * Method to counts points that already have. 
	 * @param a A 2-D array map
	 * @return the points at the begin of the games
	 */
	private int pointCounter(int[][] a) {
		int points = 0;
		for (int x = 0; x < a.length; x++){
		    for (int y = 0; y < a[0].length; y++){
		        if ( a[x][y] == 4)
		            points++;
		    }
		}
	return points;
	}
	
	/**
	 * Method to counts the goal points to win the game
	 * @param a A 2-D array map
	 * @return The goal points that is needed to win the game
	 */
	private int goalCounter(int [][] a)  {
		int theGoal = 0;
		for (int x = 0; x < a.length; x++){
		    for (int y = 0; y < a[0].length; y++){
		        if (a[x][y] == 3  || a[x][y] == 4)
		            theGoal++;
		    }
		}
	return theGoal;
	}
	
	/**
	 *{@inheritDoc}
	 * @precondition x >= -1 && x <= 1 || y >= -1 && y <= 1
	 */
	public void move(int x, int y){ 
		assert x >= -1 && x <= 1 : "Please move only one step at a time";
		assert y >= -1 && y <= 1 : "Please move only one step at a time";
		if(canMove){
		player.setImagePath("player.png"); 
		if(map[player.getX()+x][player.getY()+y] != 0){ 
			player.setxAxis(player.getxAxis() + x*speed); 
			player.setyAxis(player.getyAxis() + y*speed); 
		}
		
		int XYOfNextMove = map[player.getX()][player.getY()];
		int XYOf2Moves = map[player.getX()+x][player.getY()+y];

		
		if(XYOfNextMove == 2 ) 
			if(XYOf2Moves == 0 ||XYOf2Moves == 2 ||XYOf2Moves == 4){ 
				player.setxAxis(player.getxAxis() - x*speed);		 
				player.setyAxis(player.getyAxis() - y*speed);		
				 XYOfNextMove = map[player.getX()][player.getY()];
				 XYOf2Moves = map[player.getX()+x][player.getY()+y];
			}else if(XYOf2Moves == 1){ 
				XYOf2Moves = 2;
				XYOfNextMove = 1;   
			} 
			else if(XYOf2Moves == 3){
				winner++;
				XYOf2Moves = 4;  
				XYOfNextMove = 1; 
			} 
		if(XYOfNextMove == 4) 	 
			if(XYOf2Moves == 0 ||XYOf2Moves== 2||XYOf2Moves== 4){ 
				player.setxAxis(player.getxAxis() - x*speed);		
				player.setyAxis(player.getyAxis() - y*speed);		
				 XYOfNextMove = map[player.getX()][player.getY()];
				 XYOf2Moves = map[player.getX()+x][player.getY()+y];
			}else if(XYOf2Moves == 1){ 
				winner--;
				XYOf2Moves = 2;
				XYOfNextMove = 3;   
			} 
			else if(XYOf2Moves == 3){
				XYOf2Moves = 4;  
				XYOfNextMove = 3; 
			}
		map[player.getX()+x][player.getY()+y] = XYOf2Moves;   
		map[player.getX()][player.getY()] = XYOfNextMove;  
		
			youWin();
		
		repaint();
		}
	} 

	 
 /**
  * {@inheritDoc}
  */
	public void paint(Graphics g) { 
		
		for(int i = 0; i < map.length; i ++) { 
			for(int j= 0; j < map[0].length; j ++) { 
				if(map[i][j] == 0)  
				g.drawImage(wall.getImage(), i*32, j*32, null); 
				if(map[i][j] == 1)  
					g.drawImage(blank.getImage(), i*32, j*32, null); 
				if(map[i][j] == 2)  
					g.drawImage(crate.getImage(), i*32, j*32, null); 
				if(map[i][j] == 3)  
					g.drawImage(blankM.getImage(), i*32, j*32, null); 
				if(map[i][j] == 4)  
					g.drawImage(crateM.getImage(), i*32, j*32, null); 
			} 		 
		} 
		player.drawPlayer(g); 
	} 
	
	 /**
	  *{@inheritDoc}
	  */
	public void reset(){
		stopTimer();
		canMove = true;
		map = new int[][]{ 
			  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			  { 0, 3, 2, 1, 1, 1, 1, 1, 1, 0 }, 
			  { 0, 2, 1, 1, 2, 1, 1, 1, 1, 0 }, 
			  { 0, 1, 1, 1, 3, 2, 1, 1, 1, 0 }, 
			  { 0, 1, 1, 1, 2, 3, 3, 2, 1, 0 }, 
			  { 0, 2, 1, 1, 3, 1, 1, 1, 4, 0 }, 
			  { 0, 2, 2, 1, 1, 1, 1, 2, 2, 0 }, 
			  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
			}; 
		goal =  goalCounter(map);
		winner = pointCounter(map);
		player = new Player(32, 32, "player.png"); 
		repaint();
		stopWav();
		playWav("Mario.wav");
		startTimer(10);
	}
	
	/**
	 * Make a pop up Jframe to announce an input text and reset the game when click on the announcement
	 * @param a Set text on the pop up window. 
	 */
	public void popUp(String a){
		 final JFrame parent = new JFrame();
	        JButton button = new JButton();

	        button.setText(a);
	        parent.add(button);
	        parent.pack();
	        parent.setLocation(map.length*10, map[0].length*10);
	        parent.setVisible(true);

	        button.addActionListener(new java.awt.event.ActionListener() {
	            @Override
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                reset();
	                parent.setVisible(false);
	            }
	        });
	}
	
	@Override 
	public void keyReleased(KeyEvent arg0) { 
		// TODO Auto-generated method stub 
		 
	} 
 
	@Override 
	public void keyTyped(KeyEvent arg0) { 
		// TODO Auto-generated method stub 
		 
	}
	/**
	 *  Lose the game when timer runs out.
	 */
	@Override
	public void timerAction() {
		youLost();
	}
	
	/**
	 * Move the player to the left when press left arrow key.
	 */
	@Override
	public void left() {
		move(-1,0);
	}

	/**
	 * Move the player to the right when press right arrow key.
	 */
	@Override
	public void right() {
		move(1,0);	
	}
	
	/**
	 * Move the player upward when press up arrow key.
	 */
	@Override
	public void up() {
		move(0,-1);
	}
	
	/**
	 * Move the player downward when press down arrow key.
	 */
	@Override
	public void down() {
		move(0,1);
	}

	/**
	 * reset the game when press space key.
	 */
	@Override
	public void space() {
		reset();
		
	}

	/**
	 * {@inheritDoc}
	 */
	public void youWin(){
		if(goal == winner){
			canMove = false;
			stopTimer();
			stopWav();
			playWav("win.wav");
			popUp("You win");
		}
	}
		 
	 
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void youLost() {
		canMove = false;
		stopWav();
		playWav("Lost.wav");
		stopTimer();	
		popUp("You lost");		
	}


	
} 