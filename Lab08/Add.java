import java.util.*;

public class Add {
	private void run() {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Long> pq = new PriorityQueue<>();
		long sum = 0;
		
		int Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			int quertType = sc.nextInt();

			if (quertType == 1) {
				long num = sc.nextInt();
				pq.offer(num - sum);
			}

			if (quertType == 2) {
				int incr = sc.nextInt();
				sum += incr;
			}

			if (quertType == 3) {
				if (pq.isEmpty()) {
					System.out.println("None");
				} else {
					System.out.println(pq.poll() + sum);
				}
			}
		}
	}

	public static void main(String[] args) {
		Add add = new Add();
		add.run();
	}
}