import java.util.*;

public class Palindrome {

    // tryDelete(string, 0, string.length() - 1);
    public int tryDelete(String string, int front, int back) {
        if (front > back) return 0;
        
        if (string.charAt(front) == string.charAt(back))
            return tryDelete(string, front + 1, back - 1);
        
        int deleteFront = 1 + tryDelete(string, front, back - 1);
        int deleteBack  = 1 + tryDelete(string, front + 1, back);

        return Math.min(deleteFront, deleteBack);
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            String string = sc.next();
            int K = sc.nextInt();
            
            int deletions = tryDelete(string, 0, string.length() - 1);
            
            String output = (deletions <= K) ? "YES" : "NO";
            System.out.println(output);
        }
    }

    public static void main(String args[]) {
        Palindrome runner = new Palindrome();
        runner.run();
    }
}