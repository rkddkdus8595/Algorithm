import java.util.*;
public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            String[] str = sc.next().split(",");
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[1]);
            System.out.println(a+b);
        }
    }
}