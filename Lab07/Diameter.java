import java.util.*;

public class Diameter {
	public class Node {
		Node left, right;
		int height = 1;
	}

	/**
	 * Returns the height of Node curr.
	 * Precond: For initial call to method, curr has to be root.
	 * Postcon: Updates the height of each node/subtree.
	 */
	public int updateHeights(Node curr) {
		if (curr == null) return 0;
		int leftHeight = updateHeights(curr.left);
		int rightHeight = updateHeights(curr.right);
		curr.height = Math.max(leftHeight, rightHeight) + 1;
		return curr.height;
	}

	/**
	 * Returns the diameter of the subtree at curr.
	 * Precond: For initial call to method, curr has to be root.
	 * Postcon: Nil.
	 */
	public int getDiameter(Node curr) {
		if (curr == null) return 0;

		int leftHeight = 0;
		if (curr.left != null) 
			leftHeight = curr.left.height;

		int rightHeight = 0;
		if (curr.right != null) 
			rightHeight = curr.right.height;

		int currDiameter = leftHeight + rightHeight;
		int leftDiameter = getDiameter(curr.left);
		int rightDiameter = getDiameter(curr.right);

		return Math.max(currDiameter, Math.max(leftDiameter, rightDiameter));
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int numNodes = sc.nextInt();

		// creating individual nodes
		Node[] nodes = new Node[numNodes];
		for (int i = 0; i < numNodes; i++) {
		    nodes[i] = new Node();
		}

		// linking nodes to form tree
		for (int i = 1; i < numNodes; i++) {
			int parent = sc.nextInt() - 1;
			if (nodes[parent].left == null) {
				nodes[parent].left = nodes[i];
			} else {
				nodes[parent].right = nodes[i];
			}
		}

		Node root = nodes[0];
		updateHeights(root);
		System.out.println(getDiameter(root));
	}

	public static void main(String[] args) {
		Diameter diameter = new Diameter();
		diameter.run();	
	}
}
