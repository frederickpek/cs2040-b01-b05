import java.util.*;

public class Transpose {
    public void run() {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        String[][] grid = new String[R][C];
        
        for (int row = 0; row < R; row++) {
            grid[row] = sc.next().split("");
        }

        for (int col = 0; col < C; col++) {
            for (int row = 0; row < R; row++) {
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Transpose transpose = new Transpose();
        transpose.run();
    }
}

