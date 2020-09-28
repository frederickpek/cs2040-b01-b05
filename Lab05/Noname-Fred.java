import java.util.*;

public class Noname {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int T = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);

		int back = n - 1;
		long answer = 0;

		for (int front = 0; front < n; front++) {
			while (back > 0 && a[front] + a[back] > T) back--;
			
			if (front >= back) break;
			
			answer += (back - front);
		}

		System.out.println(answer);
	}

	public static void main(String[] args) {
		Noname runner = new Noname();
		runner.run();
	}
}
