import java.util.*;

public class Website {
	HashMap<String, HashMap<String, Integer>> hashmap = new HashMap<>(); 
	HashMap<String, Integer> maxDuration = new HashMap<>();

	/**
	 * Updates the global hashmaps according to query 1
	 * Precond: country and ip should be in valid String format
	 * Postcon: "hashmap" and "maxDuration" will be updated accordingly
	 */
	private void updateHashmaps(String country, String ip, int duration) {
		HashMap<String, Integer> innermap = hashmap.get(country);
		int prevDuration = 0;
		if (innermap != null) {
			if (innermap.containsKey(ip)) {
				prevDuration = innermap.get(ip);
			}
		} else innermap = new HashMap<>();
		int newDuration = duration + prevDuration;
		innermap.put(ip, newDuration);
		hashmap.put(country, innermap);

		// updating the maxDuration hashmap
		int max = 0;
		if (maxDuration.containsKey(country)) {
			max = maxDuration.get(country);
		}
		maxDuration.put(country, Math.max(max, newDuration));
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int numQueries = sc.nextInt();

		for (int i = 0; i < numQueries; i++){
			int queryType = sc.nextInt();

			if (queryType == 1) {
				String ip = sc.next();
				String country = sc.next();
				int duration = sc.nextInt();
				updateHashmaps(country, ip, duration);
			}

			if (queryType == 2) {
				String country = sc.next();
				int max = 0;
				if (maxDuration.containsKey(country)) {
					max = maxDuration.get(country);
				}
				System.out.println(max);
			}

			if (queryType == 3) {
				int numCountries = hashmap.size();
				System.out.println(numCountries);
			}

			if (queryType == 4) {
				String country = sc.next();
				HashMap<String, Integer> innermap = hashmap.get(country);
				int numUnique = 0;
				if (innermap != null) numUnique = innermap.size();
				System.out.println(numUnique);
			}
		}        
	}

	public static void main(String[] args) {
		Website runner = new Website();
		runner.run();
	}
}