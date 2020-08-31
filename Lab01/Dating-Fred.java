import java.util.*;

public class Dating {
	Scanner sc = new Scanner(System.in);
	Queue<Person> maleQueue = new LinkedList<>();
	Queue<Person> femaleQueue = new LinkedList<>();
	int sumTurns = 0;
	int numMatches = 0;

	public class Person {
		public String name;
		public int turn;
		public Person(String name, int turn) {
			this.name = name;
			this.turn = turn;
		}
	}

	private void tryMatch() {
		if (!maleQueue.isEmpty() && !femaleQueue.isEmpty()) {
			Person male = maleQueue.poll();
			Person female = femaleQueue.poll();
			int turnsWaited = Math.abs(male.turn - female.turn);
			sumTurns += turnsWaited;
			numMatches += 2;
			System.out.println(male.name + " matches " + female.name);
		}
	}

	private void run() {
		int numTurns = sc.nextInt();

		for (int turn = 0; turn < numTurns; turn++) {
			String gender = sc.next();
			String name = sc.next();
			Person person = new Person(name, turn);
			
			if (gender.equals("MALE")) {
				maleQueue.offer(person);
			} else {
				femaleQueue.offer(person);
			}

			tryMatch();
		}

		double averageWaitingTime = (double) sumTurns / numMatches;
		System.out.printf("%.2f\n", averageWaitingTime);
	}

	public static void main(String[] args) {
		Dating dating = new Dating();
		dating.run();
	}
}