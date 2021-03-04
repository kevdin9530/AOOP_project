package secondAssignment.SignalObs;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Signal {
	private double amplitude;
	private final int SAMPLING = 1000;
	private ArrayList<SignalObserver> myObservers;
	private Sampler mySampler;

	public void addObserver(SignalObserver s) {
		myObservers.add(s);
	}
	

	public Signal() {
		myObservers = new ArrayList<SignalObserver>();
		mySampler = new Sinus(0.0,0.2);
		Timer t = new Timer(SAMPLING, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextValue(mySampler.read());
			}
		});
		t.start();
	}
	
	private void nextValue(double x) {
		amplitude = x;
		for (SignalObserver so : myObservers) {
			so.updateSignal(amplitude);
		}
		
	}
}