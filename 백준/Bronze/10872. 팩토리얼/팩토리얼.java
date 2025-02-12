import java.util.*;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int number = sc.nextInt();
		
		int ans = fac(number);
		System.out.println(ans);
    }
    
	static int fac(int n) {
		if(n <= 1) return 1;
		return n*fac(n-1);
	}
}