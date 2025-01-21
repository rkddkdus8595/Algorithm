import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
		int[][] time = new int[book_time.length][2];
		
		// 분으로 변경해서 저장
		for(int i=0; i<book_time.length; i++) {
			time[i][0] = Integer.parseInt(book_time[i][0].split(":")[0])*60+Integer.parseInt(book_time[i][0].split(":")[1]);
			time[i][1] = (Integer.parseInt(book_time[i][1].split(":")[0])*60+Integer.parseInt(book_time[i][1].split(":")[1]))+10;
		}
		
		// 입실시간 기준으로 정렬
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 시작 시간이 같다면 종료시간 순으로 정렬 
				if(o1[0]==o2[0]) 
					return o1[1]-o2[1];
				return o1[0]-o2[0];
			}
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<time.length; i++) {
			if(pq.isEmpty()) {
				pq.add(time[i][1]);
				continue;
			}
			if(pq.peek() <= time[i][0]) {
				pq.poll();
				pq.add(time[i][1]);
			}else {
				pq.add(time[i][1]);
			}
		}
        answer = pq.size();
        return answer;
    }
}