import java.util.*;
public class Main {    
	static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        dp = new Integer[n+1];
        
        dp[0] = dp[1] = 1; 
        System.out.print(recur(n));
    }
    static int recur(int n) {
		if(dp[n] == null) {
			dp[n] = (recur(n-1)+recur(n-2))%10007;
		}
		return dp[n];
	}
}