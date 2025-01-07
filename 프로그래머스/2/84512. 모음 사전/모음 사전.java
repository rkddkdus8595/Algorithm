class Solution {
    public static int cnt = 0;
	public static boolean flag = false;
	public static char[] arr = {'A','E','I','O','U'};
    public int solution(String word) {
        int answer = 0;
        dfs(word, "");
        answer = cnt;
        return answer;
    }
    static void dfs(String word, String cur) {
		if(cur.equals(word)) {
			flag = true;
			return;
		}
		if(cur.length() >= 5) return;
		
		for(char c : arr) {
			if(!flag) {
				cnt++;
				dfs(word, cur+c);
			}
		}
	}
}