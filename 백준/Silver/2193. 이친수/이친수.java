import java.util.*;
public class Main {
	static Long[] dp;
    public static void main(String[] args) {        
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        dp = new Long[n+1];
        
        System.out.print(recur(n));
    }
    static long recur(int n) {
		if(n==1) return 1;
		if(n==2) return 1;
        
        if(dp[n] == null){
            dp[n] = recur(n-1)+recur(n-2);    
        }		
		return dp[n];
	}
}