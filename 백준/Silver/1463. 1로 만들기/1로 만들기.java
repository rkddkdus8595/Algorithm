import java.util.*;
public class Main {
	static Integer[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        // X%3==0, X%2==0, -1
        // 위 세개를 적절히 조합해서 1을 만든다.
        dp = new Integer[n+1];
        
        dp[0] = dp[1] = 0; 
        System.out.print(top(n));
    }
    static int top(int n) {
        if(dp[n] == null) {
            if(n%6==0) {
                dp[n] = Math.min(top(n-1), Math.min(top(n/3), top(n/2)))+1;
            }
            else if(n%3==0) {
                dp[n] = Math.min(top(n/3), top(n-1))+1;
            }
            else if(n%2==0) {
                dp[n] = Math.min(top(n/2), top(n-1))+1;
            }else {
                dp[n] = top(n-1)+1;
            }
        }
        return dp[n];		
    }
}
