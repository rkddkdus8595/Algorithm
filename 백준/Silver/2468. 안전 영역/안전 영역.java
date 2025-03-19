import java.util.*;
import java.io.*;
public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int map_max = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int N;
	static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		int max = 0;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				map_max = Math.max(map_max, map[i][j]);
			}
		}
		for(int m=0; m<=map_max; m++) {
			cnt = 0;
			visit = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j] && map[i][j] > m) {
						cnt++;
						dfs(i, j, m);
					}
				}
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
    }
    static void dfs(int a, int b, int h) {
		visit[a][b] = true;
		for(int i=0; i<4; i++) {
			int nx = a+dx[i];
			int ny = b+dy[i];
			if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]
				&& map[nx][ny] > h){
					dfs(nx, ny, h);
				}
		}
	}
}