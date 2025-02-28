import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer>[] lst;
	static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		lst = new ArrayList[N+1];
		dist = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			lst[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			lst[A].add(B); // 단방향
		}
		Arrays.fill(dist, -1);
		bfs(X);
		boolean flag = false;
		for(int i=1; i<=N; i++) {
			if(dist[i] == K) {
				System.out.println(i);
				flag=true;
			}
		}
		if(!flag) {
			System.out.println(-1);
		}
    }
    static void bfs(int n) {
		Queue<Integer> que = new LinkedList<>();
		que.add(n);
		dist[n]++;
		while(!que.isEmpty()) {
			int temp = que.poll();
			for(int next : lst[temp]) {
				if(dist[next] == -1) {
					dist[next] = dist[temp]+1;
					que.add(next);
				}
			}
		}
	}
}