import java.util.*;
class Solution {
	static int[] visit;
	static ArrayList<ArrayList<Node>> lst;
	static int cnt = 0; 
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        lst = new ArrayList<ArrayList<Node>>();
		
		for(int i=0; i<N+1; i++) {
			lst.add(new ArrayList<>());
		}
		
		for(int i=0; i<road.length; i++) {
			int x = road[i][0];
			int y = road[i][1];
			int time = road[i][2];
			
			// 양방향
			lst.get(x).add(new Node(y, time));
			lst.get(y).add(new Node(x, time));
		}
		
		visit = new int[N+1];
		Arrays.fill(visit, Integer.MAX_VALUE);

		visit[1] = 0;
		bfs(N, K);
        
        return cnt;
    }
    static void bfs(int N, int K) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if (n.time > visit[n.x]) continue;
			for (Node next : lst.get(n.x)) {
                int time = next.time + visit[n.x];
                
                if (time < visit[next.x]) {
                	visit[next.x] = time;
                	pq.add(new Node(next.x, time));
                }
            }
		}
		
		for(int i=1; i<N+1; i++){
			if(visit[i] <= K) {
				cnt++;
			}
		}
		
	}
	static class Node implements Comparable<Node>{
		int x, time;
		Node(int x, int time){
			this.x = x;
			this.time = time;
		}
		 @Override
        public int compareTo(Node o) {
            return time - o.time;
        }
	}
}