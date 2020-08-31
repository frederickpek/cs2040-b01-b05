import java.util.*;

public class HelloWorld {
    public void run() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equals("Hello World")) {
            System.out.println("Correct");
        } else {
            System.out.println("Incorrect");
        }
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.run();
    }
}
