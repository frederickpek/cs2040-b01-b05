import java.util.*;

public class Speakers {
	private void run() {
		Scanner sc = new Scanner(System.in);
		int Q = sc.nextInt();
		long L = sc.nextLong();
		TreeSet<Long> speakers = new TreeSet<>();
		speakers.add(-L-1);
		speakers.add(1000000000000000000L + L + 1);
		for (int i = 0; i < Q; ++i){
			String query = sc.next();
			long startTime = sc.nextLong();
			if (query.equals("INSERT")) {
				if (speakers.floor(startTime) <= startTime - L && 
						speakers.ceiling(startTime) >= startTime + L) {
					System.out.println("Y");
					speakers.add(startTime);
				} else {
					System.out.println("N");
				}
			} else if (query.equals("REMOVE")) {
				if (speakers.contains(startTime)) {
					System.out.println("Y");
					speakers.remove(startTime);
				} else {
					System.out.println("N");
				}
			} 
		}
		speakers.pollFirst();
		speakers.pollLast();
		System.out.print(speakers.pollFirst());
		for (Long startTime : speakers) {
			System.out.print(" " + startTime);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Speakers newSpeakers = new Speakers();
		newSpeakers.run();
	}
}
