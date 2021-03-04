package firstAssignment;

/*
 * Create our own Stack class that has extra methods/functions to push/pop multiple object
 */
import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

public class listStack {

	private static ArrayList<Integer> theArray;

	public listStack() {

		theArray = new ArrayList<Integer>();

	}

	public static void pushOne(int val) {
		theArray.add(val);
	}

	public static int popOne() {
		int a = theArray.get(theArray.size() - 1);
		theArray.remove(theArray.size() - 1);
		return a;
	}

	public static int theSize() {
		return theArray.size() - 1;
	}

	public static void pushList(int n, ArrayList<Integer> a) {

		for (int i = 0; i < n; i++) {
			pushOne(a.get(i));
		}

	}

	public static ArrayList<Integer> popList(int n) {

		if (n > theArray.size()) {
			throw new RuntimeException("you want to pop more elements than there is :(");
		}

		ArrayList<Integer> temp = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			temp.add(popOne());
		}

		return temp;
	}

	public String toString() {
		String a = "[";

		for (int i = 0; i < theArray.size() - 1; i++) {
			a += +popOne() + ",";

		}
		a += "]";
		return a;
	}

	public static void main(String[] args) {

		listStack a = new listStack();
		ArrayList<Integer> listan = new ArrayList<>();
		listan.add(1);
		listan.add(2);
		listan.add(3);
		listan.add(4);
		listan.add(3);
		listan.add(4);
		listan.add(3);
		listan.add(4);
		a.pushList(5, listan);
		ArrayList<Integer> poppadLista = a.popList(5);
		System.out.println(poppadLista.toString());
		System.out.println("----------------------");
		System.out.println(listan.toString());
		System.out.println(a.theSize());

	}

}