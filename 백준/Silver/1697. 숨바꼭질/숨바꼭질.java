import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[] visit = new int[100001];
	static int cnt = 0;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		bfs(N, K);
		System.out.println(cnt);
	}
	
	static void bfs(int n, int m) {
		Queue<Integer> que = new LinkedList<>();
		que.add(n);
		visit[n] = 1;
		
		while(!que.isEmpty()) {
			int temp = que.poll();
			if(temp == m) {
				cnt = visit[temp]-1;
				return;
			}
			
			if(temp-1 >= 0 && visit[temp-1] == 0) {
				visit[temp-1] = visit[temp]+1;
				que.add(temp-1);
			}
			if(temp+1 <= 100000 && visit[temp+1] == 0) {
				visit[temp+1] = visit[temp]+1;
				que.add(temp+1);
			}
			if(2*temp <= 100000 && visit[2*temp] == 0) {
				visit[2*temp] = visit[temp]+1;
				que.add(2*temp);
			}
		}
    }
}