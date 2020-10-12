import java.util.*;

public class Lca {
	private class Node {
		int index, value;
		Node left, right;
		Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

	/**
	 * Returns the index of the LCA of values u and v
	 * Precond: curr has to be the root node for initial call
	 */
	private int lowestCommonAncester(Node curr, int u, int v) {
		if (curr.value < u && curr.value < v)
			return lowestCommonAncester(curr.right, u, v);

		if (curr.value > u && curr.value > v)
			return lowestCommonAncester(curr.left, u, v);

		return curr.index;
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();

		// creating individual nodes
		Node[] nodes = new Node[n];
		for (int i = 0; i < n; i++) {
			int index = i + 1;
			int value = sc.nextInt();
			nodes[i] = new Node(index, value);
		}

		// linking nodes to form tree
		for (int i = 1; i < n; i++) {
			String type = sc.next();
			int p = sc.nextInt() - 1;
			int u = sc.nextInt() - 1;
			if (type.equals("L")) {
				nodes[p].left = nodes[u];
			} else {
				nodes[p].right = nodes[u];
			}
		}

		// processing queries
		while (q-- > 0) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			System.out.println(lowestCommonAncester(nodes[0], nodes[u].value, nodes[v].value));
		}
	}

	public static void main(String[] args) {
		Lca lca = new Lca();
		lca.run();
	}
}
