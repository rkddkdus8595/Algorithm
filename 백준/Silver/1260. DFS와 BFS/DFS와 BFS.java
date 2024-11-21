import java.util.*;
public class Main {    
	static int[][] map;
	static boolean[] visit;
	static int N;
	static Queue<Integer> que = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		dfs(V); // 탐색을 시작할 정점의 번호 입력
		System.out.println();
		visit = new boolean[N+1];
		bfs(V);
    }
    static void dfs(int num) {
		visit[num] = true;
		System.out.print(num+" ");
		
		for(int i=1; i<= N; i++) {
			if(map[num][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
		
	}
	
	static void bfs(int num) {
		que.add(num);
		visit[num] = true;
		System.out.print(num+" ");
		while(!que.isEmpty()) {
			int temp = que.poll();
			for(int i=1; i<=N; i++) {
				if(map[temp][i] == 1 && !visit[i]) {
					que.add(i);
					visit[i] = true;
					System.out.print(i+" ");
				}
			}
		}
	}
}