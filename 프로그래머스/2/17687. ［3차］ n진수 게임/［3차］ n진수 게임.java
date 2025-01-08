class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for(int i=0; i<=t*m; i++) {
			sb.append(Integer.toString(i, n));
		}
		
		// 자신의 숫자부터 시작
		for(int i=p-1; i<t*m; i+=m) {
			sb2.append(sb.charAt(i));
		}
        answer = sb2.toString().toUpperCase();
        return answer;
    }
}