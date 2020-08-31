import java.util.*;

public class Statistics {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long sum = 0L;
        
        for (int i = 0; i < N; i++) {
            sum += sc.nextLong();
        }

       double average = (double) sum / N;

       System.out.println("Sum: " + sum);
       System.out.printf("Average: %.2f\n", average);
    }

    public static void main(String[] args) {
        Statistics statistics = new Statistics();
        statistics.run();
    }
}
