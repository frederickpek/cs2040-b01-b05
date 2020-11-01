import java.util.*;

class Height {
	ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
	long relHeight[];
	boolean visited[];

	class Edge {
		int dest, heightDiff;
		Edge(int dest, int heightDiff) {
			this.dest = dest;
			this.heightDiff = heightDiff;
		}
	}

	void DFS(int vertex) {
		visited[vertex] = true;
		ArrayList<Edge> neighbours = adjList.get(vertex);
		for (Edge edge : neighbours) {
			int n = edge.dest;
			if (!visited[n]) { 
				relHeight[n] = relHeight[vertex] + edge.heightDiff;
				DFS(n);
			}
		}
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		relHeight = new long[N];
		visited = new boolean[N];

		// Initialising -> O(V)
		for (int i = 0; i < N; i++) {
			adjList.add(new ArrayList<>());
			relHeight[i] = 0L;
			visited[i] = false;
		}

		// Reading in edges -> O(E)
		for (int i = 0; i < N - 1; i++) {
			int A = sc.nextInt() - 1;
			int B = sc.nextInt() - 1;
			int H = sc.nextInt();
			adjList.get(A).add(new Edge(B,  H));
			adjList.get(B).add(new Edge(A, -H));
		}

		// Preprocessing -> O(V + E)
		DFS(0);

		// Processing query -> O(1) each!
		int Q = sc.nextInt();
		for (int i = 0; i < Q; i++) {
			int X = sc.nextInt() - 1;
			int Y = sc.nextInt() - 1;
			long diff = relHeight[Y] - relHeight[X];
			System.out.println(diff);
		}
	}

	public static void main(String[] args) {
		Height height = new Height();
		height.run();
	}
}