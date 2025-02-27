import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer> lst[];
	static int[] visit; 
	static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); // 그래프 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수
			visit = new int[V+1];
			answer = "YES";
			lst = new ArrayList[V+1];
			// 초기화
			for(int j=0; j<V+1; j++) {
				lst[j] = new ArrayList<>();
			}
			for(int j=0; j<E; j++) {
				// 간선의 정보
				st = new StringTokenizer(br.readLine());
				
				// 두 정점의 번호
				int u = Integer.parseInt(st.nextToken()); 
				int v = Integer.parseInt(st.nextToken());  
				
				lst[u].add(v);
				lst[v].add(u);
			}
			for(int j=1; j<=V; j++) {
				if(visit[j] == 0) {
					if(!bfs(j)) {
						break;
					}
				}
			}
			System.out.println(answer);
		}
    }
    static boolean bfs(int n) {
		Queue<Integer> que = new LinkedList<>();
		que.add(n);
		visit[n] = 1;	
		while(!que.isEmpty()) {
			int number = que.poll();
			for(int q : lst[number]) {
				if(visit[number] == visit[q]) {
					answer = "NO";
					return false;
				}
				if(visit[q] == 0) {
					visit[q] = visit[number]*-1;
					que.add(q);
				}
			}
		}
		return true;
	}
}