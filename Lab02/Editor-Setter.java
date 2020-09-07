import java.util.*;

public class Editor {
    private void run() {
        Scanner sc = new Scanner(System.in);
        LinkedList<Character> editor = new LinkedList();
        LinkedList<Character> buffer = new LinkedList();
        
        String s = sc.next();
        for (int i = 0; i < s.length(); i++) {
        	editor.add(s.charAt(i));
        }

      	ListIterator<Character> iterator = editor.listIterator();

      	int T = sc.nextInt();
      	while (T-- > 0) {

      		String type = sc.next();
      		if (type.equals("R")) {
      			if (iterator.hasNext()) {
      				iterator.next();
      			}
      		}

      		if (type.equals("L")) {
      			if (iterator.hasPrevious()) {
      				iterator.previous();
      			}
      		}

      		if (type.equals("C")) {
      			int k = sc.nextInt();
      			int hasMoved = 0;
      			buffer.clear();
      			for (int i = 0; i < k; i++) {
      				if (iterator.hasNext()) {
      					hasMoved++;
      					Character value = iterator.next();
      					buffer.add(value);
      				} else {
      					break;
      				}
      			}
      			for (int i = 0; i < hasMoved; i++) {
      				iterator.previous();
      			}
      		}

      		if (type.equals("P")) {
      			for (Character value: buffer) {
      				iterator.add(value);
      			}
      			buffer.clear();
      		}

      		if (type.equals("I")) {
      			Character value = sc.next().charAt(0);
      			iterator.add(value);
      		}

      		if (type.equals("B")) {
      			if (iterator.hasPrevious()) {
      				iterator.previous();
      				iterator.remove();
      			}
      		}
      	}

     	for (Character c: editor) {
     		System.out.print(c);
     	}
        
     	System.out.println();
    }

    public static void main(String[] args) {
        Editor newEditor = new Editor();
        newEditor.run();
    }
}
