import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10];

        for(int i=1; i<=9; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<=9; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][1]%1000000000;
                }else if(j == 9){
                    dp[i][j] = dp[i-1][8]%1000000000;
                }else{
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
                }
            }
        }

        long sum = 0;
        for(int i=0; i<=9; i++){
            sum += dp[N][i];
        }
        System.out.println(sum%1000000000);

    }
}