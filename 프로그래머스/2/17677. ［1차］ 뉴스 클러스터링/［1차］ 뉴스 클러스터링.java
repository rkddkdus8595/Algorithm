import java.io.IOException;
import java.util.HashSet;
import java.util.ArrayList;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        // 두글자씩 잘라서 저장할 리스트
		ArrayList<String> set1 = new ArrayList<>();
		ArrayList<String> set2 = new ArrayList<>();
		double a = 0.0, b = 0.0;
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		ArrayList<String> ans1 = new ArrayList<>();
		ArrayList<String> ans2 = new ArrayList<>();
		
		for(int i=0; i<str1.length()-1; i++) {
			String str = str1.substring(i, i+2);
			if(str.matches("^[a-zA-Z]*$")) {
				set1.add(str);
			}
		}
		for(int i=0; i<str2.length()-1; i++) {
			String str = str2.substring(i, i+2);
			if(str.matches("^[a-zA-Z]*$")) {
				set2.add(str);
			}
		}
		
		if(set1.size()==0&&set2.size()==0) answer = 1*65536;
		else {
			
			// 교집합
			for(String str : set1) {
				if(set2.remove(str)) {
					ans1.add(str);
					
				}
				ans2.add(str);
			}
			for(String str : set2) {
				ans2.add(str);
			}
			a = ans1.size(); b = ans2.size();
			answer = (int) ((a/b)*65536);
		}
        return answer;
    }
}