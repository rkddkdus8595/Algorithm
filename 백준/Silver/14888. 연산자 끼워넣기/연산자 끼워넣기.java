import java.util.*;
public class Main {    
	static int T;
	static int[] number;
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt(); 
        number = new int[T];
        arr = new int[4];
        		
        // 숫자 입력
        for(int i=0; i<T; i++) {
        	number[i] = sc.nextInt();
        }
        
        // 연산자 입력
        for(int j=0; j<4; j++) {
        	arr[j] = sc.nextInt();
        }
        
        dfs(1, number[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void dfs(int idx, int num) {
		if(idx == T) {
			max = Math.max(max, num);
			min = Math.min(min, num);
            return;
		}
		
		for(int i=0; i<4; i++) {
			if(arr[i] > 0) {
				arr[i]--;
				
				switch(i) {
				case 0: dfs(idx+1, num+number[idx]); break; 
				case 1: dfs(idx+1, num-number[idx]); break;
				case 2: dfs(idx+1, num*number[idx]); break;
				case 3: dfs(idx+1, num/number[idx]); break;
				}
				
				arr[i]++;
			}
		}
	}
}