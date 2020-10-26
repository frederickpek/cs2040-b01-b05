import java.util.*;

public class Median {
	PriorityQueue<Integer> right = new PriorityQueue<>();
	PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());

	/**
	 * Inserts value into our data structure of 2 PQs.
	 * Precond: Left and Right PQs have to be "balanced".
	 * Postcon: Value will be inserted into either left 
	 *			or right and both will be balanced afterwards.
	 */
	void insert(int value) {
		if (right.size() == 0 || value > right.peek()) {
			right.add(value);
		} else left.add(value);
		balance();
	}

	/**
	 * Maintains the invariant in our data structure: 
	 * Right PQ will always have 1 or equal number of 
	 * elements as the left PQ.
	 * Precond: Left and Right PQs have to be "balanced".
	 * Postcon: Elements in PQ may be shifted for balancing.
	 */
	void balance() {
		if (right.size() - left.size() > 1) {
			left.add(right.poll());
		} else if (left.size() - right.size() > 0) {
			right.add(left.poll());
		}
	}

	/**
	 * Prints the median elements onto System.out.
	 * Precond: Left and Right PQs have to be "balanced".
	 * Postcon: Median elements will be printed.
	 */
	void printMedian() {
		if (right.size() + left.size() == 0 ) {
			System.out.println("None");
		} else if (right.size() - left.size() == 1) {
			System.out.println(right.peek());
		} else {
			System.out.println(left.peek() + " " + right.peek());
		}
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int numQueries = sc.nextInt();
		for (int i = 0; i < numQueries; i++) {
			int type = sc.nextInt();

			if (type == 1) {
			   int value = sc.nextInt();
			   insert(value);
			} 

			if (type == 2) {
				printMedian();
			}
		}
	}

	public static void main(String[] args) {
		Median median = new Median();
		median.run();
	}
}
