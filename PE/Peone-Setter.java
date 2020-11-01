import java.util.*;

public class Peone {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextLong();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int j = 0;
		long currentSum = 0;
		long answer = 0;
		for (int i = 0; i < n; i++) {
			currentSum += a[i];
			while (currentSum >= k && j <= i) {
				currentSum -= a[j];
				j++;
			}
			answer += Math.max(0, j);
		}
		System.out.println(answer);

	}

	public static void main(String[] args) {
		Peone runner = new Peone();
		runner.run();
	}
}
