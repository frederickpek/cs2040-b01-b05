import java.util.*;

public class Trip {
	ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	int[] values;
	boolean[] visited;

	void DFS(int source) {
		visited[source] = true;
		for (Integer v : adjList.get(source)) {
			if (!visited[v]) {
				DFS(v);
			}
		}
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int S = sc.nextInt() - 1;
		int T = sc.nextInt() - 1;
		visited = new boolean[n];
		values = new int[n];

		// Initialise -> O(V)
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
			values[i] = sc.nextInt();
		}

		// Read in Edges -> O(E)
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;

			// edges are directional
			if (values[v] > values[u]) {
				adjList.get(u).add(v);
			}
			
			if (values[u] > values[v]) {
			    adjList.get(v).add(u);
			} 
		}

		// O(V + E)
		DFS(S);

		// O(1)
		if (visited[T]) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

		// Overall TC -> O(V + E)
	}

	public static void main(String[] args) {
		Trip runner = new Trip();
		runner.run();
	}
}
