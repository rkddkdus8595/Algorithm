import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        // id랑 닉네임 저장
		HashMap<String, String> id_map = new HashMap<>();
		ArrayList<String> lst = new ArrayList<>();
		
		for(int i=0; i<record.length; i++) {
			String[] arr = record[i].split(" ");
			
			// arr[0] : Enter, Leave, Change
			// arr[1] : ID
			// arr[2] : 닉네임
			
			if("Enter".equals(arr[0])) {
				id_map.put(arr[1], arr[2]);				
			}else if("Leave".equals(arr[0])) {
				continue;
			}else if("Change".equals(arr[0])) {
				id_map.put(arr[1], arr[2]);
			}
		}
		
		for(int i=0; i<record.length; i++) {
			String[] arr = record[i].split(" ");
			
			if("Enter".equals(arr[0])) {
				lst.add(id_map.get(arr[1])+"님이 들어왔습니다.");			
			}else if("Leave".equals(arr[0])) {
				lst.add(id_map.get(arr[1])+"님이 나갔습니다.");
			}else if("Change".equals(arr[0])) {
				;
			}
		}
        answer = new String[lst.size()];
        for(int i=0; i<lst.size(); i++){
            answer[i] = lst.get(i);
        }
        return answer;
    }
}