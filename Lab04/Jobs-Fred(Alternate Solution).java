import java.util.*;

public class Jobs {
	/**
	 * Tries all possible ways to split the job
	 * Pre Cond  : For initial call to method, i, w1, w2, w3 to be 0
	 */
	public long splitJob(int i, long w1, long w2, long w3, int[] arr, int n) {
		if (i == n) {
			return Math.max(w1, Math.max(w2, w3));
		}

		// try all 3 ways i can split the jobs
		long path1 = splitJob(i + 1, w1 + arr[i], w2, w3, arr, n);
		long path2 = splitJob(i + 1, w1, w2 + arr[i], w3, arr, n);
		long path3 = splitJob(i + 1, w1, w2, w3 + arr[i], arr, n);

		return Math.min(Math.min(path1, path2), path3);
	}

	private void run() {
    	Scanner sc = new Scanner(System.in);

    	// scanning input
    	int n = sc.nextInt();
    	int[] arr = new int[n];
    	for (int i = 0; i < n; i++) {
    		arr[i] = sc.nextInt();
    	}

    	// try all cases
    	long answer = splitJob(0, 0, 0, 0, arr, n);

    	// output ans
    	System.out.println(answer);
    }

    public static void main(String args[]) {
        Jobs jobs = new Jobs();
        jobs.run();
    }
}
