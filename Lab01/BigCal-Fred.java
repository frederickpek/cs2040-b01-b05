public class BigCal {
	/**
	 * pre-cond	 : size needs to be the length of the number with more digits
	 * post-cond : int[] returned will be in {ones, tens, hundreds, ...} order
	 */
	private int[] parseIntArray(String s, int size) {
		int[] arr = new int[size];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(s.length() - 1 - i) - '0';
		}
		return arr;
	}

	/**
	 * pre-cond	 : a & b must have same length padded with 0
	 * post-cond : b will be altered to be the addition of a and b
	 */
	private void add(int[] a, int[] b) {
		for (int i = 0; i < a.length - 1; i++) {
			int sum = a[i] + b[i];
			b[i] = sum % 10;
			b[i + 1] += sum / 10;
		}
		b[a.length - 1] += a[a.length - 1];
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();

		int length = Math.max(s1.length(), s2.length());

		int[] a = parseIntArray(s1, length);
		int[] b = parseIntArray(s2, length);

		add(a, b);

		for (int i = length - 1; i >= 0; i--) {
			System.out.print(b[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BigCal newBigcal = new BigCal();
		newBigcal.run();
	}
}