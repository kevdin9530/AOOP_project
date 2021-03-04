package secondAssignment.SignalObs;
//Observer pattern

public class StarObserver implements SignalObserver {

	public void updateSignal(double amp) {
		int val = (int) amp;
		for (int i = 0; i < val; i++)
			System.out.print("*");
		System.out.println();
	}

}