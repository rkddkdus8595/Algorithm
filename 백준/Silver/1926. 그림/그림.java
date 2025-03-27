import java.util.*;
import java.io.*;
public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int n, m;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		ArrayList<Integer> lst = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					lst.add(bfs(i, j));
					
				}
			}
		}
		Collections.sort(lst);
		if(lst.isEmpty()) {
			System.out.print(lst.size()+"\n"+"0");	
		}else {
			System.out.print(lst.size()+"\n"+lst.get(lst.size()-1));
		}
		
		
    }
    static int bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x,y});
		visit[x][y] = true;
		int paint_size = 1;
		while(!que.isEmpty()) {
			int[] q = que.poll();
			int cx = q[0];
			int cy = q[1];
			
			for(int i=0; i<4; i++) {		
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx >= 0 && ny >= 0 && nx < n && ny < m 
						&& !visit[nx][ny] && map[nx][ny] == 1) {
					paint_size++;
					visit[nx][ny] = true;
					que.add(new int[] {nx, ny});
				}
			}
		}
		return paint_size;
	}
}