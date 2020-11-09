import java.util.*;

public class Covid {
	ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	Integer[] dist;

	void BFS(List<Integer> sources) {
		Queue<Integer> queue = new LinkedList<>();
		for (Integer v : sources) {
			dist[v] = 0;
			queue.offer(v);
		}

		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : adjList.get(u)) {
				if (dist[v] == -1) {
					dist[v] = dist[u] + 1;
					queue.offer(v);
				}
			}
		}
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		dist = new Integer[n];

		// Initialise things -> O(V)
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<Integer>());
			dist[i] = -1; // treat -1 as not visited
		}

		// Read in Edges -> O(E)
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			adjList.get(x).add(y);
			adjList.get(y).add(x);
		}

		// Read in source vertices -> O(V)
		int k = sc.nextInt();
		List<Integer> sources = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt() - 1;
			sources.add(x);
		}
		
		// O(V + E)
		BFS(sources);

		// Linearly scan dist[] -> O(V)
		List<Integer> list = Arrays.asList(dist);
		if (list.contains(-1)) {
			System.out.println("Some are safe!");
		} else { 
			System.out.println(Collections.max(list));
		}

		// Overall TC -> O(V + E)
	}

	public static void main(String[] args) {
		Covid runner = new Covid();
		runner.run();
	}
}