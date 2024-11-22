import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static char[][] map;
	static boolean[][] visit;
	static int N, M;
	static int w_sum = 0, b_sum = 0, cnt = 0;
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로 (열)
		M = Integer.parseInt(st.nextToken()); // 세로 (행)
		
		map = new char[M][N];
		visit = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();  
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j] == false) {
					cnt = 0;
					dfs(i, j, map[i][j]);
					if(map[i][j] == 'W') {
						w_sum+= Math.pow(cnt, 2);						
					}else {
						b_sum += Math.pow(cnt, 2);
					}
				}
			}
		}
		System.out.println(w_sum+" "+b_sum);
	}	
    static void dfs(int x, int y, char c) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		
		visit[x][y] = true;
		cnt++;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx >= 0 && nx < M && ny >= 0 && ny < N && visit[nx][ny] == false && map[nx][ny] == c) {
				dfs(nx, ny, map[nx][ny]);
			}
		}
	}
}