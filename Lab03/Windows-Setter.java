import java.util.*;

public class Windows {
    private void run() {
        // scanning input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); 
        int m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) 
            a[i] = in.nextInt();
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < m - 1; i++) {
            if (a[i] % 2 == 1)
                q.add(i);
        }

        // sliding the window and printing
        for (int i = m - 1; i < n; i++) {
            if (a[i] % 2 == 1) q.add(i);
            while (q.isEmpty() == false && i - q.peek() + 1 > m) {
                q.poll();
            }
            if (q.isEmpty()) System.out.print(-1);
            else System.out.print(q.peek() + 1);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Windows windows = new Windows();
        windows.run();
    }
}
