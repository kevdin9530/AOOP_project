package secondAssignment.SignalObs;
public class TestSignal2 {
	public static void main(String[] args) {
		Signal theSignal = new Signal();
		theSignal.addObserver(new StarObserver());
		theSignal.addObserver(new SignalWindow());
	}
}