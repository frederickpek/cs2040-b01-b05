import java.util.*;

public class Feeding {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Stack<Long> input = new Stack<>();
        Stack<Long> fishes = new Stack<>();
        
        // scanning input
        for (int i = 0; i < n; i++)
            input.push((long)sc.nextInt());
        
        // reversing stack
        for (int i = 0; i < n; i++)
            fishes.push(input.pop());
        
        // simulating feeding
        for (int i = 0; i < m; i++) {
            long newFish = sc.nextInt();
            while (fishes.size() > 0 && fishes.peek() < newFish) {
                newFish += fishes.pop();
            }
            fishes.push(newFish);
        }

        for (int i = 0; i < fishes.size(); i++) {
            System.out.print(fishes.pop());
            if (i!=answer-1) System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Feeding feeding = new Feeding();
        feeding.run();
    }
}
