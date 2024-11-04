import java.util.*;
public class Main {    
	static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        
        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            dp = new Integer[n+1];
            
            System.out.println(recur(n));
        }
    }
    static int recur(int n) {
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;
        
		if(dp[n] == null) {
			dp[n] = recur(n-1)+recur(n-2)+recur(n-3);
		}
		return dp[n];
	}
}