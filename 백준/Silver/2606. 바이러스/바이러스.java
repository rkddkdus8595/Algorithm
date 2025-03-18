import java.util.*;
import java.io.*;
public class Main {
	static int[][] map;
	static boolean[] visit;
	static int cnt = 0;
	static int N, M;
    public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visit = new boolean[N+1];
		map = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		bfs(1);
		System.out.println(cnt);
    }
    static void bfs(int a) {
		Queue<Integer> que = new LinkedList<>();
		que.add(a);
		visit[a] = true;
		
		while(!que.isEmpty()) {
			int n = que.poll();
			for(int i=1; i<N+1; i++) {
				if(!visit[i] && map[n][i] == 1) {
					visit[i] = true;
					cnt++;
					que.add(i);
				}
			}
		}
    }
}