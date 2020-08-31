import java.util.*;

public class Dating {
    public class Person {
        String name; int time;
        Person(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        Queue<Person> male = new LinkedList<>();
        Queue<Person> female = new LinkedList<>();
        int n = in.nextInt();
        int sumTime = 0; int couple = 0;
        for (int i = 1; i <= n; i++) {
            String type, name;
            type = in.next();
            name = in.next();
            if (type.equals("MALE")) male.add(new Person(name, i));
            else female.add(new Person(name, i));
            if (!male.isEmpty() && !female.isEmpty()) {
                Person cur_male = male.poll();
                Person cur_female = female.poll();
                System.out.println(cur_male.name + " matches " + cur_female.name);
                couple++;
                sumTime += 2 * i - cur_male.time - cur_female.time;
            }
        }
        System.out.printf("%.2f\n", (double)(sumTime) / couple / 2);

    }

    public static void main(String args[]) {
        Dating dating = new Dating();
        dating.run();
    }
}
