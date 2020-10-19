import java.util.*;

public class Dictionary {
	public class Node {
		Node left, right;
		int prefixCount = 0;
	}

	/**
	 * Adds "string", starting from root, to create branches.
	 * Precond: For initial call to method, curr has to be root.
	 * Postcon: Branches from root and prefixCounts will be updated.
	 */
	public void addString(Node curr, String string) {
		for (Character c : string.toCharArray()) {
			if (c.equals('a')) {
				if (curr.left == null) curr.left = new Node();
				curr = curr.left;
			} else {
				if (curr.right == null) curr.right = new Node();
				curr = curr.right;
			}
			curr.prefixCount++;
		}
	}

	/**
	 * Returns the number of strings with a given prefix.
	 * Precond: For initial call to method, curr has to be root.
	 * Postcon: Returns the number of strings with a given prefix.
	 */
	public int countPrefixes(Node curr, String prefix) {
		for (Character c : prefix.toCharArray()) {
			if (c.equals('a')) {
				curr = curr.left;
			} else curr = curr.right;
			if (curr == null) return 0;
		}
		return curr.prefixCount;
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int numStrings = sc.nextInt();
		int numQueries = sc.nextInt();

		Node root = new Node();

		// building tree from strings
		for (int i = 0; i < numStrings; i++) {
			String string = sc.next();
			addString(root, string);
		}

		// traversing tree for prefixes
		for (int i = 0; i < numQueries; i++) {
			String prefix = sc.next();
			System.out.println(countPrefixes(root, prefix));
		}
	}

	public static void main(String[] args) {
		Dictionary dict = new Dictionary();
		dict.run();
	}
}
