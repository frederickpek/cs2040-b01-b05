import java.util.*;

public class Shooting {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		ArrayList<TreeSet<Integer>> horizontal = new ArrayList<>();
		ArrayList<TreeSet<Integer>> vertical = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			horizontal.add(new TreeSet<>());
			vertical.add(new TreeSet<>());
		}
		int curX = 0;
		int curY = 0;
		int enemies = 0;
		for (int q = 0; q < Q; ++q) {
			String query = sc.next();
			if (query.equals("SHOOT")) {
				String dir = sc.next();
				Integer x = null, y = null;
				if (dir.equals("UP")) {
					x = vertical.get(curY).lower(curX);
					y = curY;
				} else if (dir.equals("DOWN")) {
					x = vertical.get(curY).higher(curX);
					y = curY;
				} else if (dir.equals("LEFT")) {
					x = curX;
					y = horizontal.get(curX).lower(curY);
				} else if (dir.equals("RIGHT")) {
					x = curX;
					y = horizontal.get(curX).higher(curY);
				}
				if (x == null || y == null) {
					System.out.println("MISSED");
				} else {
					System.out.println(x.toString() + " " + y.toString());
					horizontal.get(x).remove(y);
					vertical.get(y).remove(x);
					enemies--;
				}
			} else if (query.equals("TELEPORT")) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				curX = x;
				curY = y;
			} else if (query.equals("SPAWN")) {
				++enemies;
				int x = sc.nextInt();
				int y = sc.nextInt();
				horizontal.get(x).add(y);
				vertical.get(y).add(x);
			}
		}
		boolean first = true;
		for (int row = 0; row < N; ++row) {
			for (int col : horizontal.get(row)) {
				if (first) first = false;
				else System.out.print(" ");
				System.out.print(row + " " + col);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Shooting newShooting = new Shooting();
		newShooting.run();
	}
}
