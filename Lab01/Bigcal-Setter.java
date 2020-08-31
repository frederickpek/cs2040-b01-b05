/**
 * Name         :
 * Matric. No   :
*/

import java.util.*;

public class Bigcal {
	private static class BigNum {
		private ArrayList<Integer> d;
		///"1234" will be represented by [4, 3, 2, 1], this should make implementation easier

		public BigNum(String s) {
			d = new ArrayList<>();
			for (int i = s.length() - 1; i >= 0; i--) {
				d.add(s.charAt(i) - '0');
			}
		}

		public BigNum(ArrayList<Integer> newD) {
			this.d = newD;
		}

		public int get(int position) {
			return d.get(position);
		}

		public int length() {
			return this.d.size();
		}

		public void addInitialDigit(int digit) {
			d.add(digit);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = d.size() - 1; i >= 0; i--) {
				int nd = ('0' + d.get(i));
				sb.append((char) nd);
			}
			return sb.toString();
		}
	}

	BigNum add(BigNum a, BigNum b) {
		ArrayList<Integer> c = new ArrayList<>();
		int carry = 0;
		while (a.length() < b.length()) a.addInitialDigit(0);
		while (b.length() < a.length()) b.addInitialDigit(0);
		for (int i = 0; i < a.length(); i++) {
			int ci = a.get(i) + b.get(i) + carry;
			carry = 0;
			if (ci >= 10) {
				carry = 1;
				ci -= 10;
			}
			c.add(ci);
		}
		if (carry > 0) {
			c.add(carry);
		}
		return new BigNum(c);
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		System.out.print(add(new BigNum(a), new BigNum(b)));
	}

	public static void main(String[] args) {
		Bigcal newBigcal = new Bigcal();
		newBigcal.run();
	}
}

