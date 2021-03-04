package secondAssignment.Filter;


public abstract class Filter {
	abstract boolean accept(String x);

	public final String[] filter(String[] a) {

		String wholeString = "";
		for (int i = 0; i < a.length; i++) {
			if (accept(a[i])) {
				wholeString += a[i] + ",";
			}
		}
		String[] filteredStringA = wholeString.split(",");
		return filteredStringA;

	}
}
