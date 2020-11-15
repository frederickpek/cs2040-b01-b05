// prim's version

import java.util.*;

public class Hypercar {
	List<List<Edge>> adjList = new ArrayList<>();

	private static class Edge implements Comparable<Edge> {
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
		
		// this compareTo sorts larger w first.
		public int compareTo(Edge other) {
			return other.w - this.w;
		}
	}

	/**
	 * This method will attempt to use prim's algo to 
	 * join the roads from source S, terminating once T is joined.
	 * The lowest speed limit added thus far is returned.
	 * ie, this is an early terminating prims algo.
	 */
	int shortestRoad(int source, int destination) {
		int min = Integer.MAX_VALUE;
		boolean[] inMST = new boolean[adjList.size()];
		inMST[source] = true;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (Edge v : adjList.get(source)) {
			pq.add(v);
		}

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			min = Math.min(min, curr.w);
			inMST[curr.v] = true;
			if (inMST[destination]) return min;
			for (Edge v : adjList.get(curr.v)) {
				if (!inMST[v.v]) pq.add(v);
			}
		}

		return -1;
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int S = sc.nextInt() - 1;
		int T = sc.nextInt() - 1;

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			int w = sc.nextInt();
			adjList.get(u).add(new Edge(u, v, w));
			adjList.get(v).add(new Edge(v, u, w));
		}

		int min = shortestRoad(S, T);

		if (min == -1) System.out.println("Impossible");
		else System.out.println(min);
	}

	public static void main(String[] args) {
		Hypercar runner = new Hypercar();
		runner.run();
	}
}
