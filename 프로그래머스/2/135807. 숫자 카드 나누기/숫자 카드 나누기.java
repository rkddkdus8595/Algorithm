class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int number_A = arrayA[0];
		int number_B = arrayB[0];
		
		for(int i=1; i<arrayA.length; i++) {
			number_A = gcd(number_A, arrayA[i]);
			number_B = gcd(number_B, arrayB[i]);
		};
		
		if(div(arrayB, number_A)) {
			if(answer < number_A) answer = number_A;
		}
		
		if(div(arrayA, number_B)) {
			if(answer < number_B) answer = number_B;
			
		}
        return answer;
    }
    static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}
	
	// 나눌 수 있는지 확인하는 함수
	static boolean div(int[] arr, int n) {
		for(int a : arr) {
			if(a % n == 0) {
				return false;
			}		
		}
		return true;
	}
}