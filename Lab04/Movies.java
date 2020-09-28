import java.util.*;

public class Movies {
	int n, m;
	Movie[] movies;
	boolean[] chosen;

	public class Movie {
		int left, right, score;
		public Movie(int left, int right, int score) {
			this.left = left;
			this.right = right;
			this.score = score;
		}

		/** returns true if we clash timings with the other movie, false otherwise */
		public boolean intersects(Movie other) {
			return (right > other.left && other.right > left);
		}
	}

	/** returns true if the movie can fit into our schedule, false otherwise */
	public boolean canWatch(Movie movie) {
		for (int i = 0; i < movies.length; i++) {
			if (chosen[i] && movies[i].intersects(movie)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Tries all possible ways to pick movies
	 * Pre Cond  : For initial method call, (i, numChosen, score) to be 0
	 * Post Cond : boolean[] chosen array would be altered
	 */
	public long pickMovies(int i, int numChosen, long score) {
		if (i == n || numChosen == m) return score;

		long path1 = 0;
		if (canWatch(movies[i])) {
			chosen[i] = true;
			path1 = pickMovies(i + 1, numChosen + 1, score + movies[i].score);
		}

		chosen[i] = false;
		long path2 = pickMovies(i + 1, numChosen, score);

		return Math.max(path1, path2);
	}

    private void run() {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	m = sc.nextInt();

    	// creating Movies[] array and scanning details
    	movies = new Movie[n];
    	chosen = new boolean[n];
    	for (int i = 0; i < n; i++) {
    		int left = sc.nextInt();
    		int right = sc.nextInt();
    		int score = sc.nextInt();
    		movies[i] = new Movie(left, right, score);
    	}

    	System.out.println(pickMovies(0, 0, 0));
    }

    public static void main(String args[]) {
        Movies runner = new Movies();
        runner.run();
    }
}