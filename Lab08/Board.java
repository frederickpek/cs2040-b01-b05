import java.util.*;

public class Board {
	ArrayList<PriorityQueue<Integer>> rows = new ArrayList<>();
	ArrayList<PriorityQueue<Integer>> cols = new ArrayList<>();
	HashSet<Integer> set = new HashSet<>();

	/**
	 * Prints the result of the given query.
	 * Precond: rows, cols & set has to be updated accordingly.
	 * Postcon: rows, cols & set will be altered for removals.
	 */
	public void processQuery(String queryType, int pos) {
		ArrayList<PriorityQueue<Integer>> list;
		list = queryType.equals("R") ? rows : cols;
		PriorityQueue<Integer> pq = list.get(pos);

		while (!pq.isEmpty()) {
			Integer maxValue = pq.poll();
			if (!set.contains(maxValue)) {
				System.out.println(maxValue);
				set.add(maxValue);
				return;
			}
		}

		if (pq.isEmpty()) System.out.println("None");
	}

	/**
	 * Returns a PriorityQueue ordered non-decreasingly.
	 */
	public PriorityQueue<Integer> maxHeap() {
		Comparator<Integer> rev = Comparator.reverseOrder();
		return new PriorityQueue<>(rev);
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		
		// updating the PQs and HashSet
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			rows.add(maxHeap());
			for (int j = 0; j < N; j++) {
				if (i == 0) cols.add(maxHeap());
				int value = sc.nextInt();
				rows.get(i).offer(value);
				cols.get(j).offer(value);
			}
		}

		// processing queries
		int Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			String type = sc.next();
			int pos = sc.nextInt() - 1;
			processQuery(type, pos);
		}
	}

	public static void main(String[] args) {
		Board board = new Board();
		board.run();
	}
}