import java.util.*;

public class Zero {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = sc.nextInt();
		
		// cumulative sum array creation
		long[] sumArray = new long[n];
		sumArray[0] = a[0];
		for (int i = 1; i < n; i++)
			sumArray[i] = sumArray[i - 1] + a[i];

		Arrays.sort(sumArray);
		long answer = 0;
		int last = -1;
		for (int i = 0; i < n; i++) {

			if (i == n - 1 || sumArray[i] != sumArray[i + 1]) {
				int n = i - last;
				answer += (long) n * (n - 1) / 2;
				last = i;
			}

			if (sumArray[i] == 0) {
				answer++;
			}

		}

		System.out.println(answer);
	}

	public static void main(String[] args) {
		Zero runner = new Zero();
		runner.run();
	}
}
