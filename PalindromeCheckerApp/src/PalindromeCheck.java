import java.util.*;

class QueueStackPalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Insert characters
        for(char c : str.toCharArray()){
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;

        // Compare dequeue and pop
        while(!queue.isEmpty()){
            if(queue.remove() != stack.pop()){
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome){
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        sc.close();
    }
}