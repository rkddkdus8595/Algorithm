import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        String str = sc.next();
        for(int i=0; i<n; i++){
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }        
        System.out.println(sum);
    }
}