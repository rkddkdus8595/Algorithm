import java.util.*;
import java.io.*;
public class Main {
	static int[][] map;
	static int cnt = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> lst = new ArrayList<>();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j=y1; j<y2; j++) {
				for(int k=x1; k<x2; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) {
					cnt = 1;
					dfs(i, j);
					lst.add(cnt);
				}
			}
		}
		Collections.sort(lst);
		System.out.println(lst.size());
		for(int i=0; i<lst.size(); i++) {
			System.out.print(lst.get(i)+" ");
		}
    }
    static void dfs(int x, int y) {
		map[x][y] = 1;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx >= 0 && ny >= 0 && ny < N && nx < M) {
				if(map[nx][ny] == 0) {
					cnt++;
					dfs(nx, ny);
				}
					
			}
		}
	}
}