import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        int[] answer;
		ArrayList<Integer> lst = new ArrayList<>();
		
		int cnt = 1, start = 0, last = 0, msg_length = 27;
		String last_word = "";
		HashMap<String, Integer> map = new HashMap<>();
		
		// 문자열 인덱스 A-Z 저장
		for(char i='A'; i<='Z'; i++) {
			map.put(i+"", cnt++);
		}
		
		// 문자 찾기
		while(last <= msg.length()) {
			last = start + 1;
			String str = msg.substring(start, last);
			
			while(map.containsKey(str)) {
				last_word = str;
				last++;
				if(last > msg.length()) break;
				
				str = msg.substring(start, last);
			}
			
			lst.add(map.get(last_word));
			map.put(str, msg_length);
			msg_length++;
			start = last-1;
		}
		answer = new int[lst.size()];
		for(int i=0; i<lst.size(); i++) {
			answer[i] = lst.get(i);
		}
        return answer;
    }
}