import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer> lst[];
	static boolean[] visit;
	static int[] par;
	static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		lst = new ArrayList[N+1];
		par = new int[N+1];
		visit = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			lst[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lst[a].add(b);
			lst[b].add(a);
		}
		bfs(1);
		for(int i=2; i<=N; i++) {
			System.out.println(par[i]);	
		}
    }
    static void bfs(int a) {
		visit[a] = true;
		Queue<Integer> que = new LinkedList<>();
		que.add(a);
		
		while(!que.isEmpty()) {
			int q = que.poll();
			for(int n : lst[q]) {
				if(!visit[n]) {
					que.add(n);
					visit[n] = true;
					par[n] = q;
				}
			}
		}
	}
}