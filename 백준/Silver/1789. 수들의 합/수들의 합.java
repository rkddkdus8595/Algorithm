import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		long sum = 0;
		long n = 1;
		while(true) {
			sum += n;
			if(sum > num) break;
			n++;
		}
		System.out.println(n-1);
    }
}