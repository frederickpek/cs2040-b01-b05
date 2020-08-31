import java.util.*;

public class Mexseq {
    private void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int a[] = new int[505];
        for (int i = 1; i <= n; i++) {
            int l = in.nextInt();
            a[l]++;
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if (a[i] == 0) ans++;
        }
        ans += a[k];
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Mexseq newMexseq = new Mexseq();
        newMexseq.run();
    }
}
