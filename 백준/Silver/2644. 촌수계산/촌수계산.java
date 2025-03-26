import java.util.*;
import java.io.*;
public class Main {    
	static ArrayList<Integer> lst[];
	static int[] visit;
	static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		lst = new ArrayList[n+1];
		visit = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			lst[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			lst[x].add(y);
			lst[y].add(x);
		}
		Arrays.fill(visit, -1);
		bfs(a, b);
		System.out.println(visit[b]);
    }
    static void bfs(int x, int y) {
		Queue<Integer> que = new LinkedList<>();
		que.add(x);
		visit[x] = 0;
		
		while(!que.isEmpty()) {
			int a = que.poll();
			for(int b : lst[a]) {
				if(visit[b] == -1) {
					que.add(b);
					visit[b] = visit[a]+1;
				}
			}
		}
	}
}