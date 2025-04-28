import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(br.readLine());
		long[] dp;
		dp = new long[100+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			for(int j=6; j<=N; j++) {
				dp[j] = dp[j-2]+dp[j-3];
			}
			System.out.println(dp[N]);
		}
    }
}