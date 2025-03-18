import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        long fac = 1;
		int[] answer = new int[n];
		
		ArrayList<Integer> lst = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			lst.add(i);
			fac*=i;
		}
		
		k = k-1; // 인덱스가 0부터 시작하니까 
		int idx = 0;
		while(n > idx) {
			fac /= (n-idx);
			answer[idx++] = lst.remove((int)(k/fac));
			k %= fac;
		}
        return answer;
    }
}