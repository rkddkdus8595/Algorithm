import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> que = new LinkedList<>();
        
        if(cacheSize == 0) return cities.length*5;
        
        for(int i=0; i<cities.length; i++) {
        	String city = cities[i].toLowerCase();
        	if(que.contains(city)) {
        		answer++;
        		que.remove(city);
        	}else {
        		answer+=5;
        		if(que.size() == cacheSize) {
        			que.remove();
        		}
        	}
        	que.add(city);
        }
        
        return answer;
    }
}