import java.util.*;

public class Football {
	private void run() {
		Scanner sc = new Scanner(System.in);

		// input
		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}

		// simulating n passes
		int current = 0;
		while (n-- > 0) {
			current = p[current];

			if (current == 0) {
				System.out.println("YES");
				return;
			}
		}

		System.out.println("NO");
	}

	public static void main(String args[]) {
		Football football = new Football();
		football.run();
	}
}
