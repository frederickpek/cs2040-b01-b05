import java.util.*;

public class Computergame {
	private class Pair {
		int x, y;
		Pair (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private int permute(int N, int[][] dist, int[] perm, int idx, boolean[] used) {
		if (idx == N) {
			int distance = dist[0][perm[0]] + dist[perm[N - 1]][1];
			for (int i = 0; i < N - 1; ++i) {
				distance += dist[perm[i]][perm[i + 1]];
			}
			return distance;
		}
		int shortestDistance = 1000000000;
		for (int i = 0; i < used.length; ++i) {
			if (used[i]) continue;
			used[i] = true;
			perm[idx] = i + 2;
			shortestDistance = Math.min(shortestDistance, permute(N, dist, perm, idx + 1, used));
			used[i] = false;
		}
		return shortestDistance;
	}
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		char[][] grid = new char[R][C];
		Pair[] pos = new Pair[16];
		int cp = 0;
		for (int r = 0; r < R; ++r) {
			grid[r] = sc.next().toCharArray();
			for (int c = 0; c < C; ++c) {
				if (grid[r][c] == 'S') {
					pos[0] = new Pair(r, c);
				} else if (grid[r][c] == 'T') {
					pos[1] = new Pair(r, c);
				} else if (grid[r][c] == 'C') {
					pos[cp + 2] = new Pair(r, c);
					++cp;
				}
			}
		}

		// BFS to get Distance[][] matrix from all checkpoints + S & T
		int[][] dist = new int[16][16];
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for (int i = 1; i < cp + 2; ++i) {
			Queue<Pair> queue = new LinkedList<>();
			int[][] bfs = new int[R][C];
			for (int[] row: bfs)
    			Arrays.fill(row, -1);

    		queue.add(new Pair(pos[i].x, pos[i].y));


    		bfs[pos[i].x][pos[i].y] = 0;
    		while (queue.size() > 0) {
    			Pair cur = queue.poll();
    			for (int dir = 0; dir < 4; ++dir) {
    				int newx = cur.x + dx[dir];
    				if (newx < 0 || newx >= R) continue;

    				int newy = cur.y + dy[dir];
    				if (newy < 0 || newy >= C) continue;

    				if (grid[newx][newy] == '#' || bfs[newx][newy] >= 0) continue;

    				bfs[newx][newy] = bfs[cur.x][cur.y] + 1;
    				queue.add(new Pair(newx, newy));
    			}
    		}
    		for (int j = 0; j < i; ++j) {
    			dist[i][j] = dist[j][i] = bfs[pos[j].x][pos[j].y];
    		}
		}

		System.out.println(permute(cp, dist, new int[cp], 0, new boolean[cp]));
	}

	public static void main(String[] args) {
		Computergame newComputergame = new Computergame();
		newComputergame.run();
	}
}
