package firstAssignment;

/*
 * Simple matrix using double array and apply some print and also basic addition/multiplication
 */
public class Matrix {
	private final double[][] elements;
	private final int R;
	private final int C;

	public Matrix(int r, int c) {

		this.R = r;
		this.C = c;
		elements = new double[r][c];
	}

	public double getElementAt(int rPos, int cPos) {

		double element = elements[rPos][cPos];
		return element;
	}

	public void setElementAt(int rPos, int cPos, double value) {
		elements[rPos][cPos] = value;

	}

	// Returns C = A*B
	public static Matrix multiplication(Matrix a, Matrix b) {
		if (a.C != b.R)
			throw new RuntimeException("Illegal matrix dimensions!");

		Matrix c = new Matrix(a.R, b.C);
		for (int i = 0; i < c.R; i++)
			for (int j = 0; j < c.C; j++)
				for (int k = 0; k < a.C; k++)
					c.elements[i][j] += (a.elements[i][k] * b.elements[k][j]);

		return c;
	}

	public static Matrix add(Matrix a, Matrix b) {

		if (a.R != b.R || a.C != b.C)
			throw new RuntimeException("Illegal matrix dimensions!");

		Matrix c = new Matrix(a.R, a.C);
		for (int i = 0; i < a.R; i++)
			for (int j = 0; j < a.C; j++)
				c.elements[i][j] = a.elements[i][j] + b.elements[i][j];

		return c;

	}
	public String printMaxtrix() {
		String a = "";
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				a+="[" + getElementAt(i, j) + "]";
			a+="\n";
		}
		return a;
	}

	public static void main(String[] args) {

		Matrix m = new Matrix(2, 2);
		Matrix m2 = new Matrix(2, 2);

		m2.setElementAt(0, 0, 5);
		m2.setElementAt(0, 1, 10);
		m2.setElementAt(1, 0, 15);
		m2.setElementAt(1, 1, 20);

		m.setElementAt(0, 0, 5);
		m.setElementAt(0, 1, 10);
		m.setElementAt(1, 0, 15);
		m.setElementAt(1, 1, 20);

		System.out.println("1st matrix \n"+m2.printMaxtrix());
		System.out.println("2nd matrix \n"+m.printMaxtrix());
		Matrix multi = multiplication(m, m2);
		Matrix added = add(m, m2);
		System.out.println("Sum of 2 matrix is:");
		System.out.println(added.printMaxtrix());
		System.out.println("Factor of 2 matrix is:");
		System.out.println(multi.printMaxtrix());
		
	}

}