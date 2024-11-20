import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static boolean[][] visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
//	static int N;
	static List<Integer> arr = new ArrayList<>();
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map;
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i=0 ; i<N ; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(temp.charAt(j));
            }
        }
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					cnt = 0;
					dfs(i,j, map, N);
					arr.add(cnt);
				}
			}
		}
		System.out.println(arr.size());
		Collections.sort(arr);
		for(int a : arr) {
			System.out.println(a);
		}
	}
	
	public static void dfs(int x, int y, int[][] map, int N) {
		visit[x][y] = true;
		cnt++;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N ||
					map[nx][ny] == 0 || visit[nx][ny]) continue;
			dfs(nx, ny, map, N);
		}
	}
}