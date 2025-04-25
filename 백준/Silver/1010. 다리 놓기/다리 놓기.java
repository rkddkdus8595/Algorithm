import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] dp;	
		StringBuilder sb = new StringBuilder();
		dp = new int[30][30];
		for(int i=0; i<30; i++) {
			dp[i][0] = 1;
			dp[i][i] = 1;
		}
		
		for(int i=2; i<30; i++) {
			for(int j=1; j<30; j++) {
				dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(dp[M][N]+"\n");
		}
		
		System.out.print(sb.toString());
    }
}