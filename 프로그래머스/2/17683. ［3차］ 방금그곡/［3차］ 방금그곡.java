import java.text.ParseException;
class Solution {
    public String solution(String m, String[] musicinfos) throws ParseException{
        String answer = "(None)";
        StringBuilder sb = new StringBuilder();
		
		int minute_max = 0;
		
		// C#DEFGABC#DEFGAB , ABCDE
		// 치환
		m = replace(m);
		
		for(int i=0; i<musicinfos.length; i++) {
			String[] temp = musicinfos[i].split(",");
			
			String[] time1 = temp[0].split(":");
			int start = Integer.valueOf(time1[0])*60 + Integer.valueOf(time1[1]);
			String[] time2 = temp[1].split(":");
			int end = Integer.valueOf(time2[0])*60 + Integer.valueOf(time2[1]);
			
			String name = temp[2];
			String music = replace(temp[3]); // # 치환
			
			int diff_M = end-start;

			sb = new StringBuilder();
			
			music = append_str(music, diff_M);
			
			// 기억한 멜로디가 존재한다면
			// 조건이 일치하는 음악이 여러개라면 재생된 시간이 가장 긴 음악제목 반환
			// 재생시간도 같다면 먼저 입력된 음악 반환
			if(diff_M >= m.length() && music.contains(m)) {
				if(diff_M > minute_max) {
					minute_max = diff_M;
					answer = name;
					
				}
			}
		}
        return answer;
    }
    static String append_str(String code, int time) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<time; i++) {
			sb.append(code.charAt(i%code.length()));
		}
		return sb.toString();
	}
	static String replace(String str) {
		return str.replaceAll("C#", "c")
				    .replaceAll("D#", "d")
				    .replaceAll("F#", "f")
				    .replaceAll("G#", "g")
				    .replaceAll("A#", "a")
                    .replaceAll("B#", "b");
	}	
}