import java.util.*;

public class Retransmission {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		TreeMap<Integer, Integer> cats = new TreeMap<>();
		cats.put(-2, -2);
		cats.put(2000000001, 2000000001);
		for (int q = 0; q < Q; ++q) {
			String query = sc.next();
			if (query.equals("WAKE")) {
				int i = sc.nextInt();
				int l = cats.floorKey(i);
				int r = cats.ceilingKey(i);
				if (cats.get(l) < i - 1) {
					if (r > i + 1) {
						cats.put(i, i);
					} else {
						cats.put(i, cats.get(r));
						cats.remove(r);
					}
				} else if (r > i + 1) {
					cats.put(l, i);
				} else {
					cats.put(l, cats.get(r));
					cats.remove(r);
				}
				 
			} else if (query.equals("SLEEP")) {
				int i = sc.nextInt();
				int l = cats.floorKey(i);
				if (l == i) {
					if (cats.get(l) == i) {
						cats.remove(l);
					} else {
						cats.put(l + 1, cats.get(l));
						cats.remove(l);
					}
				} else if (cats.get(l) == i) {
						cats.put(l, i - 1);	
				} else {
					cats.put(i + 1, cats.get(l));
					cats.put(l, i - 1);
				}
			} else if (query.equals("TRANSMIT")) {
				int i = sc.nextInt();
				int j = sc.nextInt();
				int l = cats.floorKey(i);
				if (cats.get(l) < j) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			}
		}
	}

	public static void main(String[] args) {
		Retransmission newRetransmission = new Retransmission();
		newRetransmission.run();
	}
}
