import java.util.Scanner;
import java.util.Stack;

class StackPalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for(int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));
        }

        boolean isPalindrome = true;

        // Pop and compare
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != stack.pop()){
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