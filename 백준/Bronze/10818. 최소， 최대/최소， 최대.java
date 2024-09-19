import java.util.*;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); 
        ArrayList<Integer> lst = new ArrayList<>();
        
        for(int i=0; i<a; i++){
            lst.add(sc.nextInt());
        }
        Collections.sort(lst);
        System.out.println(lst.get(0)+" "+lst.get(lst.size()-1));  
    }
}