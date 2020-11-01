import java.util.*;

public class Popmiddle {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		Queue<Integer> frontHalf = new LinkedList<>();
		Queue<Integer> backHalf = new LinkedList<>();
		for (int i = 0; i < Q; ++i) {
			String query = sc.next();
			if (query.equals("PUSH")) {
				int value = sc.nextInt();
				backHalf.add(value);
			} else if (query.equals("POP")) {
				if (frontHalf.size() > 0) {
					System.out.println(frontHalf.poll());
				} else {
					System.out.println(backHalf.poll());
				}
			} else if (query.equals("POPMIDDLE")) {
				System.out.println(backHalf.poll());
			}
			if (backHalf.size() - frontHalf.size() > 1) {
				frontHalf.add(backHalf.poll());
			}
		}
		while (frontHalf.size() > 0) {
			System.out.print(frontHalf.poll() + " ");
		}
		while (backHalf.size() > 0) {
			System.out.print(backHalf.poll());
			if (backHalf.size() > 0) {
				System.out.print(" ");
			} else {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		Popmiddle newPopmiddle = new Popmiddle();
		newPopmiddle.run();
	}
}
