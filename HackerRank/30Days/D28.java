import java.util.*;

public class D28 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> nameList  = new ArrayList<String>();
        
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            String[] email = in.next().split("@");
            if(email[1].equals("gmail.com")){
                nameList.add(name);
            }
        }
        in.close();
        Collections.sort(nameList);

        for(String name : nameList){
            System.out.println(name);
        }
    }
}