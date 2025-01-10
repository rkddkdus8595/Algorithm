import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stk = new Stack<>();
		int idx = 0;
		
		for(int i=1; i<=order.length; i++) {
			if(order[idx] != i) {
				stk.add(i);
			}else {
				idx++;
				answer++;
			}
			
			while(!stk.isEmpty() && stk.peek() == order[idx]) {
				stk.pop();
				answer++;
				idx++;				
			}
		}
        return answer;
    }
}