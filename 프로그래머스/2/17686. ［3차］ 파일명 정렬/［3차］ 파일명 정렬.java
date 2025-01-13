
import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
            	String head1 = o1.split("[0-9]")[0].toLowerCase();
            	String head2 = o2.split("[0-9]")[0].toLowerCase();            	
            	
            	// 같다면
            	if(head1.compareTo(head2) == 0) {
            		String n1 = o1.substring(head1.length());
            		String n2 = o2.substring(head2.length());
            		return Integer.parseInt(get_number(n1))-Integer.parseInt(get_number(n2));
            	}else {
            		return head1.compareTo(head2);
            	}
            }	
		});
        for(int i=0; i<files.length; i++){
            answer[i] = files[i];
        }
        return answer;
    }
    static String get_number(String str) {
		String result = "";
		
		for(char c : str.toCharArray()) {
			if(Character.isDigit(c) && result.length() < 5) {
				result += c;
			}else {
				break;
			}
		}
		return result;
	}
}