import java.util.*;

public class Companies {
	private class Node {
		public int value;
		public Node next = null;
		public Node(int value) {
			this.value = value;
		}
	}

	private class Company {
		public int index;
		public Node head = null;
		public Node tail = null;
		public Company(int index) {
			this.index = index;
		}

		public void addEmployee(int id) {
			Node curr = new Node(id);
			if (head == null) {	
				head = curr;
				tail = curr;
			} else {
				tail.next = curr;
				tail = curr;
			}
		}

		public void addCompany(Company company) {
			if (head == null) {
				head = company.head;
				tail = company.tail;
			} else if (company.head != null) {
				tail.next = company.head;
				tail = company.tail;
			}
		}
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		Company[] companies = new Company[M];

		// scanning employees
		for (int index = 0; index < M; index++) {
			Company curr = new Company(index);
			int numEmployees = sc.nextInt();
			for (int i = 0; i < numEmployees; i++) {
				curr.addEmployee(sc.nextInt());
			}
			companies[index] = curr;
		}

		// handling transactions
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			// u takes over v employees
			companies[u].addCompany(companies[v]); // O(1)
			companies[v] = null;
		}

		// output
		System.out.println(M - T);
		for (Company company : companies) {
			if (company == null) continue;
			System.out.print(company.index + " ");

			ArrayList<Integer> employees = new ArrayList<>();
			Node curr = company.head;
			while (curr != null) {
				employees.add(curr.value);
				curr = curr.next;
			}
			System.out.print(employees.size());
			Collections.sort(employees);
			for (Integer value : employees) {
				System.out.print(" " + value);
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Companies companies = new Companies();
		companies.run();
	}
}
