import java.util.LinkedList;
import java.util.Queue;
class Solution {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int[][] visit;
	static char[][] map;
	static int x, y;
	static int[] start, end, lev;
    public int solution(String[] maps) {
        int answer =0 ;
		int cnt = 0;
		x = maps.length; 
		y= maps[0].length();
		
		map = new char[x][y];
		visit = new int[x][y];
		
		for(int i=0; i<maps.length; i++) {
			map[i] = maps[i].toCharArray();
		}
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<maps[i].length(); j++) {
				if(map[i][j] == 'S') {
					start = new int[] {i,j};
				}else if(map[i][j] == 'E') {
					end = new int[] {i,j};
				}else if(map[i][j] == 'L') {
					lev = new int[] {i,j};
				}
				
			}
		}
		int s_l = bfs(start, lev);
		int l_e = bfs(lev, end);
		
		if(s_l == -1 || l_e == -1) answer = -1;
		else {
			answer = s_l+l_e;
		}
        return answer;
    }
    static int bfs(int[] start, int[] end) {
        visit = new int[x][y];
		Queue<int[]> que = new LinkedList<>();
		que.add(start);
		visit[start[0]][start[1]] = 1;
		
		while(!que.isEmpty()) {		
			int[] n = que.poll();
			int cx = n[0]; 
			int cy = n[1];
			
			for(int i=0; i<4; i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
					if(visit[nx][ny] <= 0 && map[nx][ny] != 'X') {
						visit[nx][ny] = visit[cx][cy]+1;
						que.add(new int[] {nx,ny});
					}
				}
				if(nx == end[0] && ny == end[1]) {
					return visit[nx][ny]-1;
				}
			}
		}
		return -1;
	}
}