// kruskal's version

import java.util.*;

public class Hypercar {
	private static class DisjoinSet {
		int d[];
		int n;

		DisjoinSet(int n) {
			this.n = n;
			this.d = new int[n];
			for (int i = 0; i < n; i++) {
				this.d[i] = -1;
			}
		}

		int findParent(int u) {
			if (d[u] < 0) {
				return u;
			}
			d[u] = findParent(d[u]);
			return d[u];
		}

		void join(int a, int b) {
			a = findParent(a);
			b = findParent(b);
			if (a != b) {
				d[b] = a;
			}
		}

		boolean isConnected(int a, int b) {
			return findParent(a) == findParent(b);
		}
	}

    private static class Edge implements Comparable<Edge> {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge other) {
        	return w - other.w;
        }
    }

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int S = sc.nextInt() - 1;
		int T = sc.nextInt() - 1;

		ArrayList<Edge> edges = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			int w = sc.nextInt();
			edges.add(new Edge(u, v, w));
		}

		Collections.sort(edges);
		Collections.reverse(edges);

		DisjoinSet dsu = new DisjoinSet(n);
		for (Edge e: edges) {
			dsu.join(e.u, e.v);
			if (dsu.isConnected(S, T)) {
				System.out.println(e.w);
				return;
			}
		}

		System.out.println("Impossible");
	}

	public static void main(String[] args) {
		Hypercar runner = new Hypercar();
		runner.run();
	}
}
