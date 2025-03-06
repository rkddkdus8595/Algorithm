class Solution {
    public String solution(int n) {
        String answer = "";
        String[] arr = {"4","1","2"};
            
        while(n > 0){
            int rem = n%3;
            n /= 3;
            
            if(rem == 0){
                n--;
            }
            answer = arr[rem]+answer;
        }
        return answer;
    }
}