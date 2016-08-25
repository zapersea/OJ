import java.util.*;
abstract class Book
{
    String title;
    String author;
    Book(String t,String a){
        title=t;
        author=a;
    }
    abstract void display();


}
class MyBook extends Book
{
	int price;
	MyBook(String title,String author,int price){
		super(title,author);
		this.price=price;
	}

	void display(){
		System.out.println("Title: "+super.title);
		System.out.println("Author: "+super.author);
		System.out.println("Price: "+this.price);
	}

}

public class D13
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String title=sc.nextLine();
        String author=sc.nextLine();
        int price=sc.nextInt();
		sc.close();
		Book newBook = new MyBook(title,author,price);
		newBook.display();
	}

}
