import java.util.*;

public class Petwo {
	MyQueue[] queues;
	private TreeSet<MyQueue> allQueues = new TreeSet<>();
	private TreeSet<MyQueue> allHeads = new TreeSet<>(new Comparator<MyQueue>(){
		///precond: two queues have size > 0
		public int compare(MyQueue first, MyQueue second) {
			if (first.queue.peek().equals(second.queue.peek())) {
				return first.id.compareTo(second.id);
			}
			return first.queue.peek().compareTo(second.queue.peek());
		}
	});

	private static class MyQueue implements Comparable<MyQueue> {
		public Queue<Integer> queue;
		public Integer id;

		public MyQueue(int id) {
			this.id = id;
			this.queue = new LinkedList<Integer>();
		}

		public int compareTo(MyQueue other) {
			if (this.queue.size() < other.queue.size()) {
				return -1;
			}
			if (this.queue.size() > other.queue.size()) {
				return 1;
			}
			return id.compareTo(other.id);
		}
	}

	private void removeQueue(MyQueue toRemove) {
		allQueues.remove(toRemove);
		if (toRemove.queue.size() > 0) {
			allHeads.remove(toRemove);
		}
	}

	private void addQueue(MyQueue toAdd) {
		allQueues.add(toAdd);
		allHeads.add(toAdd);
	}

	///return the id of the queue
	private int insert(int height)  {
		MyQueue toInsertQueue = allQueues.first();
		removeQueue(toInsertQueue);
		toInsertQueue.queue.offer(height);
		addQueue(toInsertQueue);
		return toInsertQueue.id;
	}


	///precond: allHeads.size() > 0
	private int serve() {
		MyQueue toServeQueue = allHeads.first();
		removeQueue(toServeQueue);
		int angriness = toServeQueue.queue.poll();
		allQueues.add(toServeQueue);
		if (toServeQueue.queue.size() > 0) {
			allHeads.add(toServeQueue);
		}
		return angriness;
	}

	///precond: queues[position] has at least one element
	private int move(int position) {
		removeQueue(queues[position]);
		int angriness = queues[position].queue.poll();
		allQueues.add(queues[position]);
		if (queues[position].queue.size() > 0) {
			allHeads.add(queues[position]);
		}
		return insert(angriness);
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();

		queues = new MyQueue[n];
		for (int i = 0; i < n; i++) {
			queues[i] = new MyQueue(i);
			allQueues.add(queues[i]);
		}
		
		int numberOfCustomers = 0;

		while (q-- > 0) {
			String command = sc.next();

			if (command.equals("join")) {
				int angriness = sc.nextInt();
				++numberOfCustomers;
				System.out.println(insert(angriness) + 1);
			}

			if (command.equals("serve")) {
				assert(numberOfCustomers > 0);
				--numberOfCustomers;
				System.out.println(serve());
			}

			if (command.equals("move")) {
				int position = sc.nextInt() - 1;
				assert(queues[position].queue.size() > 0);
				System.out.println(move(position) + 1);
			}
		}

	}

	public static void main(String[] args) {
		Petwo runner = new Petwo();
		runner.run();
	}
}
