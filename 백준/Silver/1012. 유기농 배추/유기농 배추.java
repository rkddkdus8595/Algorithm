import java.util.*;

import java.io.*;
public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int cnt = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int M, N, K;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			visit = new boolean[M][N];
			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[X][Y] = 1;
			}
			cnt = 0;
			for(int j=0; j<M; j++) {
				for(int k=0; k<N; k++) {
					if(map[j][k] == 1 && !visit[j][k]) {
						dfs(j, k);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
    }
    static void dfs(int a, int b) {
		visit[a][b] = true;
		
		for(int i=0; i<4; i++) {
			int nx = a+dx[i];
			int ny = b+dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visit[nx][ny] && map[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
}