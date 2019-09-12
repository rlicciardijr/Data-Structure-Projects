package Project_1;
//project 1 complex numbers
public class Complex {
	private int r;
	private int i;

	public Complex() {
		r = 0;
		i = 0;
	}

	public Complex(int realPart, int imaginaryPart) {
		r = realPart;
		i = imaginaryPart;
	}

	public Complex add(Complex a, Complex b) {
		r = a.r + b.r;
		i = a.i + b.i;
		return this;
	}

	public Complex subtract(Complex a, Complex b) {
		r = a.r - b.r;
		i = a.i - b.i;
		return this;
	}

	public void printResult(Complex complex) {
		System.out.println("(" + r + "," + i + ")");

	}

	public static void main(String[] args) {
		Complex c1 = new Complex(3, -5);
		Complex c2 = new Complex(8, 7);
		Complex sum = new Complex();
		sum.add(c1, c2);
		Complex diff = new Complex();
		diff.subtract(c1, c2);
		System.out.println("The Sum is ");
		sum.printResult(sum);
		System.out.println("The difference is ");
		diff.printResult(diff);

	}
}
