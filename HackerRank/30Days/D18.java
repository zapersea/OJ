import java.io.*;
import java.util.*;

public class D18 {
    // Write your code here.
	Queue<Character> q =new LinkedList<Character>();
	Stack<Character> s =new Stack<Character>();

    void enqueueCharacter(char c){
		this.q.offer(c);
	}

    void pushCharacter(char c){
		this.s.push(c);
	}

    char dequeueCharacter(){
		return this.q.poll();
	}

    char popCharacter(){
		return this.s.pop();
	}

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputS = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = inputS.toCharArray();

        // Create a Solution object:
        D18 p = new D18();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + inputS + ", is " 
                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}