import java.lang.reflect.Method;

class D21 {

	public static <T>  void printArray(T[] a){
		for(T temp:a){
			System.out.println(temp);
			Console.WriteLine(temp);
		}
	}
    
    public static void main(String args[]){
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = { "Hello", "World" };
        
        printArray( intArray  );
        printArray( stringArray );
        
        if(D21.class.getDeclaredMethods().length > 2){
            System.out.println("You should only have 1 method named printArray.");
        }
    }
}