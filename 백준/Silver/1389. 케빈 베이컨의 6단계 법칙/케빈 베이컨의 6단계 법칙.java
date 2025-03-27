import java.util.*;
import java.io.*;
public class Main {
	static int[][] map;
	static int N, M;
	static int INF = 999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		int min = Integer.MAX_VALUE;
		int idx = 0;
		
		
		for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) map[i][j]=INF;
            }
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[A][B] = 1;
			map[B][A] = 1;
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					 if(map[i][j] > map[i][k]+map[k][j]) {
						 map[i][j] = map[i][k]+map[k][j];
					 }
				}
			}	
		}
		for(int i=1; i<=N; i++) {
			int sum = 0;
			for(int j=1; j<=N; j++) {
				sum += map[i][j];
//				System.out.println(map[i][j]);
			}
			
			if(min > sum) {
				min = sum;
				idx = i;
			}
		}
		System.out.println(idx);
    }
}