import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
	static boolean[][] visit;
	static List<Integer> lst = new ArrayList<>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static char[][] map;
    public int[] solution(String[] maps) {
        int[] answer;
		map = new char[maps.length][maps[0].length()];
		visit = new boolean[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++) {
			map[i] = maps[i].toCharArray();
		}
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				if(!visit[i][j] && map[i][j] != 'X') {
					lst.add(dfs(i, j));
				}
			}
		}
		if(lst.isEmpty()) lst.add(-1);
		
		Collections.sort(lst);
        
        answer = new int[lst.size()];
        for(int i=0; i<lst.size(); i++){
            answer[i] = lst.get(i);
        }
        return answer;
    }
    
    static int dfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[]{x,y});
		visit[x][y] = true;
		int sum = 0;
		while(!que.isEmpty()) {
			int[] arr = que.poll();
			int cx = arr[0];
			int cy = arr[1];
			sum += (map[cx][cy]-'0');
			for(int i=0; i<4; i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
					if(!visit[nx][ny] && map[nx][ny] != 'X') {
						visit[nx][ny] = true;
						que.add(new int[] {nx,ny});
					}
				}
			}
		}
		return sum;
	}
}