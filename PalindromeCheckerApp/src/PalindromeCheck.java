import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

// Stack Strategy Implementation
class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque Strategy Implementation
class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String str) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String str) {
        return strategy.isPalindrome(str);
    }
}

// Main Class
public class PalindromeCheck{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        PalindromeContext context = new PalindromeContext();

        // Choose strategy dynamically
        System.out.println("Choose Strategy: 1. Stack  2. Deque");
        int choice = sc.nextInt();

        if (choice == 1) {
            context.setStrategy(new StackStrategy());
        } else {
            context.setStrategy(new DequeStrategy());
        }

        if (context.checkPalindrome(input)) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        sc.close();
    }
}