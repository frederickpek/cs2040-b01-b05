import java.util.*;

public class Countways {
	List<List<Edge>> adjList = new ArrayList<>();
	long dist[];
	long ways[];

	class Edge {
		int u, v, w;
		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	class Vertex implements Comparable<Vertex> {
		int index; 
		Long dist;
		Vertex(int index, Long dist) {
			this.index = index;
			this.dist = dist;
		}

		public int compareTo(Vertex other) {
			return this.dist.compareTo(other.dist);
		}
	}

	void dijkstra(int S) {
		dist[S] = 0;
		ways[S] = 1;
		Queue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(S, dist[S]));
		
		while (!pq.isEmpty()) {
			Vertex curr = pq.poll();
			int u = curr.index;
			if (curr.dist != dist[u]) continue; // Very important!
			for (Edge neighbour : adjList.get(u)) {
				int v = neighbour.v;
				int w = neighbour.w;
				if (dist[v] > dist[u] + w) { // relaxing edge
					dist[v] = dist[u] + w;
					ways[v] = ways[u];
					pq.offer(new Vertex(v, dist[v]));
				} else if (dist[v] == dist[u] + w) {
					ways[v] = (ways[v] + ways[u]) % 1000000007;
				}
			}
		}
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int S = sc.nextInt() - 1;
		int T = sc.nextInt() - 1;
		
		// Initialising -> O(V)
		dist = new long[n];
		ways = new long[n];
		for (int i = 0 ; i < n; i++) {
			adjList.add(new ArrayList<>());
			dist[i] = Long.MAX_VALUE;
			ways[i] = 0L;
		}

		// Read in Edges -> O(E)
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			int w = sc.nextInt();
			adjList.get(u).add(new Edge(u, v, w));
			adjList.get(v).add(new Edge(v, u, w));
		}

		// O((V+E)logV)
		dijkstra(S);

		System.out.println(dist[T] + " " + ways[T]);

		// Overall TC -> O((V+E)logV)
	}

	public static void main(String[] args) {
		Countways runner = new Countways();
		runner.run();
	}
}