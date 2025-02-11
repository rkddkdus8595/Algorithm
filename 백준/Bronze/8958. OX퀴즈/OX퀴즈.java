import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int count = 0;
		int sum = 0;
		for(int i=0; i<T; i++) {
			String str = sc.next();
			sum = 0;
			count = 0;
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == 'O') {
					count++;
					sum += count;
				}else {
					count = 0;
				}
			}
			System.out.println(sum);
		}
    }
}