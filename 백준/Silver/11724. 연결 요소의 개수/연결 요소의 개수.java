import java.util.*;
import java.io.*;
public class Main {
	static int[][] map;
	static boolean[] visit;
	static int N, M;
	static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visit[i]) {
				bfs(i);
				cnt++;	
			}
		}
		System.out.println(cnt);
    }
    static void bfs(int n) {
		visit[n] = true;
		Queue<Integer> que = new LinkedList<>();
		que.add(n);
		while(!que.isEmpty()) {
			int num = que.poll();
			for(int i=1; i<=N; i++) {
				if(!visit[i] && map[num][i] == 1) {
					que.add(i);
					visit[i] = true;
				}
			}
		}
	}
}