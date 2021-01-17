package firstPart;

/*
 * Using interface filter and supply a method that returns an array
 * containing all the elements of a that are accepted by the filter.
 */
public class StringFilter implements Filter {

	public static String[] filter(String[] a, Filter f) {

		String wholeString = "";
		for (int i = 0; i < a.length; i++) {
			if (f.accept(a[i])) {
				wholeString += a[i] + ",";
			}
		}
		String[] filteredStringA = wholeString.split(",");
		return filteredStringA;

	}
/*
 * the filter only accept words with length smaller than 3 characters
 */
	public boolean accept(String x) {

		if (x.length() < 3)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		String x = "Hi there! This string is going down";
		String[] xArr = x.split(" ");

		Filter f = new StringFilter();
		xArr = filter(xArr, f);
		for (int i = 0; i < xArr.length; i++) {
			System.out.println(xArr[i]);
		}
	}
}
