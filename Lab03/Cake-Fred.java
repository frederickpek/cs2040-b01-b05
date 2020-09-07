import java.util.*;

class Rect {
	int index, height;
	Rect(int index, int height) {
		this.index = index;
		this.height = height;
	}
}

public class Cake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 

		Stack<Rect> stack = new Stack<>();
		long maxArea = 0L;

		// update maxArea as we introduce more columns
		for (int index = 0; index < n + 1; index++) {
			int currentHeight = (index == n) ? 0 : sc.nextInt();
			int prevIndex = index;
			
			while (!stack.isEmpty() && currentHeight < stack.peek().height) {
				Rect prev = stack.pop();
				prevIndex = prev.index;
				int width = index - prevIndex;
				long currentArea = (long) width * prev.height;
				maxArea = Math.max(maxArea, currentArea);
			}
			
			stack.push(new Rect(prevIndex, currentHeight));
		}

		System.out.println(maxArea);
	}
}