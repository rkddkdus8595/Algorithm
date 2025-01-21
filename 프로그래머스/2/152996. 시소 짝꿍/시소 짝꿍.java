import java.util.Arrays;
import java.util.HashMap;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        // 100, 100, 180, 270, 360
		HashMap<Double, Integer> map = new HashMap<>();
		
		Arrays.sort(weights);
		
		for(int i=0; i<weights.length; i++) {
			double a = weights[i]*1.0;
			double b = (weights[i]*2.0)/3;
			double c = (weights[i]*2.0)/4;
			double d = (weights[i]*3.0)/4;
			
			if(map.containsKey(a)) answer += map.get(a);
			if(map.containsKey(b)) answer += map.get(b);
			if(map.containsKey(c)) answer += map.get(c);
			if(map.containsKey(d)) answer += map.get(d);
			map.put(weights[i]*1.0, map.getOrDefault(weights[i]*1.0, 0)+1);
		}
        return answer;
    }
}