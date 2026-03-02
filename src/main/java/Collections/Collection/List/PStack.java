package Collections.Collection.List;

import java.util.Collections;
import java.util.Stack;

public class PStack {

    static void main() {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.size());
        stack.add(30);
        stack.push(8);
        stack.add(1,4);
        stack.push(827);
        System.out.println(stack.peek());
        System.out.println(stack);
        Collections.sort(stack);
        stack.pop();
        System.out.println(stack);

        // but this is not the ideal way to use stack, we should use ArrayDeque
    }
}
