package finalSukobanProject;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.concurrent.*;
import javax.swing.*;
import javax.sound.sampled.*;

/**
 * GameFrameWork is a abstract class that a game developer can use to run their own game 
 * as long as the developer has implement required method.
 * 
 * @author Kevin Hoang Dinh and Johan Hero
 * @version 1.0
 * @since 2019-05-27
 */
public abstract class GameFrameWork extends JPanel implements KeyListener{
	private JFrame window = new JFrame("Game");	
	private Timer myTimer = null;
	private Clip clip;
	/**
	 * This method allows users to set specific size to their game windows.
	 * @param a Width of the game.
	 * @param b Height of the game.
	 */
	public void setPanelSize(int a,int b){
		window.setSize(a, b);
	}
	
	/**
	 * Main method of GameFrameWork that run the game that has been implemented 
	 * required init() method to be implemented else become a blank Jframe.
	 */
	public void run(){
		setFocusable(true);
		addKeyListener(this);
		init();
		window.add(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	
	/**
	 * Initialize functions that users have to implement in their concrete classes 
	 */
	public abstract void init();
	
	/**
	 * Methods of KeyListener. Already implemented for right, left, up, down and space button
	 */
	public void keyPressed(KeyEvent ke) { 		
			if(ke.getKeyCode()==KeyEvent.VK_RIGHT)  
					right();			  
			if(ke.getKeyCode()==KeyEvent.VK_LEFT)  
					left(); 			  
			if(ke.getKeyCode() == KeyEvent.VK_UP)  
					up();				 
			if(ke.getKeyCode() == KeyEvent.VK_DOWN)  
					down();			 
			if(ke.getKeyCode() == KeyEvent.VK_SPACE)
					space();
	} 
	
	/**
	 * User need to implement what left button is going to do
	 */
	public abstract void left();
	
	/**
	 * User need to implement what right button is going to do
	 */
	public abstract void right();
	
	/**
	 * User need to implement what up button is going to do
	 */
	public abstract void up();
	
	/**
	 * User need to implement what down button is going to do
	 */
	public abstract void down();
	
	/**
	 * User need to implement what space button is going to do
	 */
	public abstract void space();
	
	
	/**
	 * User need to implement what timer is going to do when it runs out of time
	 */
	public abstract void timerAction();
	
	/**
	 * Stop the timer. Can't resume.
	 */
	public void stopTimer(){
		myTimer.stop();
	}
	
	/**
	 * Start the timer. When reach deadline the timer will do according to timerAction()
	 * @param second Set deadline for timer in second.
	 */
	public void startTimer(int second) { //StartTimer
		
		ActionListener timeAction = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				timerAction();
			}
		};
		if(second > 0){
			myTimer = new Timer(second*1000,timeAction);
			myTimer.start();

			ActionListener setTime = new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
				}
			};

		}
	}
	
	/**
	 * A method that users can use to play sound file. Limited to only Wav file
	 * @param a Input of file name and type of file  
	 */
	public void playWav(String a){
		try{
		    File sound = new File(a);
		    clip = AudioSystem.getClip();
		    clip.open(AudioSystem.getAudioInputStream(sound));
		    clip.start();
		}
		catch(Exception ex)
		{
		}
	}
	
	/**
	 * A method to stop the current playing sound.
	 * Only able to stop the latest sound from playWav(String a) 
	 */
	public void stopWav(){
		clip.stop();	
	}
 }
