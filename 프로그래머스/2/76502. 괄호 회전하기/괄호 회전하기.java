import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stk = null;
		boolean flag = false;
		
		for(int i=0; i<s.length(); i++) {
			String new_s  = s.substring(i) + s.substring(0,i);			
			stk = new Stack<>();
			for(int j=0; j<new_s.length(); j++) {
				char c = new_s.charAt(j);
				if(stk.isEmpty()) stk.push(c);
				else if(stk.peek() == '(' && c == ')') stk.pop();
				else if(stk.peek() == '{' && c == '}') stk.pop();
				else if(stk.peek() == '[' && c == ']') stk.pop();
				else stk.push(c);
			}
			// 스택이 비어있다면 올바른 문자열
			if(stk.isEmpty()) answer++;	
		}
		
        return answer;
    }
}