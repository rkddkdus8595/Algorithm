import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(String s) {
        int[] answer;
        s = s.substring(2, s.length()-2);
		
		String[] arr = s.replace("},{", "/").split("/");
		
		ArrayList<Integer> lst = new ArrayList<>();
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
	    });
	    
		for(int i=0; i<arr.length; i++) {
			String[] str = arr[i].split(",");
			for(int j=0; j<str.length; j++) {
				if(!lst.contains(Integer.parseInt(str[j]))) {
					lst.add(Integer.parseInt(str[j]));
				}
			}
		}
        answer = new int[lst.size()];
        for(int i=0; i<lst.size(); i++){
            answer[i] = lst.get(i);
        }
        return answer;
    }
}