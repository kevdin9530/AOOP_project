package secondAssignment.Filter;
public class FilterMaxThree extends Filter {

	@Override
	boolean accept(String x) {
		if (x.length() < 3)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		String x = "Hi there! This string is going down";
		String [] xArr = x.split(" ");

		Filter a = new FilterMaxThree();
		
		xArr = a.filter(xArr);
		
		for(int i = 0; i < xArr.length; i++){
			System.out.println(xArr[i]);
		}
	}
}
