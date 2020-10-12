import java.util.*;

public class Nearest {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}

		int answer[] = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = N + 1;
		}

		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < N; i++) {
			if (map.containsKey(a[i])) {
				answer[i] = Math.min(answer[i], i - map.get(a[i]));
			}
			map.put(a[i], i);
		}

		map.clear();
		for (int i = N - 1; i >= 0; i--) {
			if (map.containsKey(a[i])) {
				answer[i] = Math.min(answer[i], map.get(a[i]) - i);
			}
			map.put(a[i], i);
		}

		for (int i = 0; i < N; i++) {
			if (answer[i] < N) {
				System.out.println(answer[i]);
			} else {
				System.out.println(-1);
			}
		}
	}

	public static void main(String[] args) {
		Nearest runner = new Nearest();
		runner.run();
	}
}
