import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
class Solution {    
	static HashMap<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        ArrayList<String> course_lst = new ArrayList<>();
		
		// 문자 정렬
		for(int i=0; i<orders.length; i++) {
			char[] chr = orders[i].toCharArray();
			Arrays.sort(chr);
			orders[i] = String.valueOf(chr);
		}
		
		
		// 조합 만들기
		for(int i=0; i<course.length; i++) {
			for(String order : orders){
				comb_menu("", order, course[i]);
			}
			
			if(!map.isEmpty()) {
				ArrayList<Integer> lst = new ArrayList<>(map.values());
				int max = Collections.max(lst);
				
				if(max>1) { // 코스는 2가지 이상임
					for(String key : map.keySet()) {
						if(map.get(key) == max) {
							course_lst.add(key);
						}
					}
				}
			}
			map.clear();
		}
		answer = new String[course_lst.size()];
		for(int i=0; i<course_lst.size(); i++) {
			answer[i] = course_lst.get(i);
		}
		
		Arrays.sort(answer);
        return answer;
    }
    
    // 메뉴 조합
	static void comb_menu(String comb, String order, int course_length) {
		if(comb.length() == course_length) {
			map.put(comb, map.getOrDefault(comb, 0)+1);
			return;
		}
		
		for(int i=0; i<order.length(); i++) {
			comb_menu(comb+order.charAt(i), order.substring(i+1), course_length);
		}
		
	}
}