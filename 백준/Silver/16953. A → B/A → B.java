import java.util.*;
import java.io.*;
public class Main {
	static int ans = 0;
	static long A, B;	
	static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A =  Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		dfs(A, 1);
		if(!flag) {
			System.out.println(-1);	
		}else {
			System.out.println(ans);
		}
    }
    static void dfs(long num, int cnt) {
		if(num > B) {			
			return;
		}
		if(num == B) {
			flag = true;
			ans = cnt;
			return;
		}
		dfs(num*2, cnt+1);
		dfs(num*10+1, cnt+1);
	}
}