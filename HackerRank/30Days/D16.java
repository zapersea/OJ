import java.io.*;
import java.util.*;

public class D16 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		try(Scanner scan = new Scanner(System.in);){
            System.out.println( Integer.parseInt(scan.nextLine()) );
        }
        catch(NumberFormatException e){
            System.out.println("Bad String");
        }
    }
}