import java.util.*;

public class Bracketflips {
	private String flip(String bracket) {
		if (bracket.equals("(")) {
			return ")";
		} else if (bracket.equals(")")) {
			return "(";
		} else if (bracket.equals("[")) {
			return "]";
		} else if (bracket.equals("]")) {
			return "[";
		} else if (bracket.equals("{")) {
			return "}";
		} else if (bracket.equals("}")) {
			return "{";
		} else return "";
	}
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		LinkedList<String> brackets = new LinkedList<>();
		boolean flipped = false;
		for (int i = 0; i < Q; ++i) {
			String query = sc.next();
			if (query.equals("FRONT")) {
				if (flipped) {
					brackets.addLast(flip(sc.next()));
				} else {
					brackets.addFirst(sc.next());
				}
			} else if (query.equals("BACK")) {
				if (flipped) {
					brackets.addFirst(flip(sc.next()));
				} else {
					brackets.addLast(sc.next());
				}
			} else if (query.equals("ROTATE")) {
				flipped = !flipped;
			}
		}
		if (flipped) {
			Collections.reverse(brackets);
			for (String s : brackets) {
				System.out.print(flip(s));
			}
		} else {
			for (String s : brackets) {
				System.out.print(s);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Bracketflips newBracketflips = new Bracketflips();
		newBracketflips.run();
	}
}
