class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];
		int num = 1, x = -1, y = 0;
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				if(i%3 == 0)  { // 아래
					x++;
				}else if(i%3 == 1) { // 오른쪽
					y++;
				}else if(i%3 == 2) {
					x--; y--;
				}
				arr[x][y] = num++;
			}
		}
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (arr[i][j] == 0) {
                    break;
                } else {
                    answer[cnt++]  = arr[i][j];
                }
            }
        }
        return answer;
    }
}