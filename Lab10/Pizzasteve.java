import java.util.*;

public class Pizzasteve {
	List<List<Edge>> adjList = new ArrayList<>();

	class Edge {
		int u, v, w;
		Edge(int u, int v, int w) {
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
	
	long[] dijkstra(int source) {
		long[] dist = new long[adjList.size()];
		for (int i = 0; i < adjList.size(); i++) {
			dist[i] = Long.MAX_VALUE;
		}

		dist[source] = 0;
		Queue<Vertex> pq = new PriorityQueue<>();
		pq.offer(new Vertex(source, dist[source]));
		
		while (!pq.isEmpty()) {
			Vertex curr = pq.poll();
			int u = curr.index;
			if (curr.dist != dist[u]) continue;
			for (Edge neighbour : adjList.get(u)) {
				int v = neighbour.v;
				int w = neighbour.w;
				if (dist[v] > dist[u] + w) {
					dist[v] = dist[u] + w;
					pq.offer(new Vertex(v, dist[v]));
				}
			}
		}

		return dist;
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int S = sc.nextInt() - 1;
		int T = sc.nextInt() - 1;

		for (int i = 0 ; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			int w = sc.nextInt();
			adjList.get(u).add(new Edge(u, v, w));
		}

		long[] distS = dijkstra(S);
		long[] distT = dijkstra(T);

		Long answer = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			answer = Math.min(answer, Math.max(distS[i], distT[i]));
		}

		if (answer == Long.MAX_VALUE) {
			System.out.println("Sad");
		} else System.out.println(answer);

	}

	public static void main(String[] args) {
		Pizzasteve runner = new Pizzasteve();
		runner.run();
	}
}