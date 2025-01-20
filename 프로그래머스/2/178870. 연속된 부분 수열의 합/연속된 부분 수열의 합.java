class Solution {
    public int[] solution(int[] sequence, int k) {
		int[] answer = new int[2];
		
		int l_idx = 0, r_idx = 0;
		int sum = sequence[0];
		int len = Integer.MAX_VALUE;
		
		while(r_idx < sequence.length) {
			if(sum == k) {
				if(r_idx - l_idx < len) { 
					len = r_idx-l_idx;
					answer[0] = l_idx;
					answer[1] = r_idx;
				}
				sum -= sequence[l_idx];
				l_idx++;
			}else if(sum > k) {
				sum -= sequence[l_idx]; l_idx++;
			}else if(sum < k) {
				r_idx++;
				if(r_idx < sequence.length)		
					sum += sequence[r_idx];		
			}
		}
        return answer;
    }
}