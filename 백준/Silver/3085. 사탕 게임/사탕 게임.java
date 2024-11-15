import java.util.*;
public class Main {    
	static int max = 0;
	static char[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		arr = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		// 행기준 체크
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				swap(arr, i, j, i, j+1);
				chk(arr, N);
				swap(arr, i, j, i, j+1);
			}
		}
		
		// 열기준 체크
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N; j++) {
				swap(arr, i, j, i+1, j);
				chk(arr, N);
				swap(arr, i, j, i+1, j);
			}
		}
		System.out.println(max);
    }
    public static void swap(char[][] arr, int x1, int y1, int x2, int y2) {
		char tmp = arr[x1][y1];
		arr[x1][y1] = arr[x2][y2];
		arr[x2][y2] = tmp;
	}
	
	public static void chk(char[][] arr, int N) {
		
		for(int i=0; i<N; i++) {
			int cnt = 1;			
			for(int j=0; j<N-1; j++) {
				if(arr[i][j] == arr[i][j+1]) {
					cnt++;
					max = Math.max(max, cnt);
				}else {
					cnt = 1;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			int cnt = 1;			
			for(int j=0; j<N-1; j++) {
				if(arr[j][i] == arr[j+1][i]) {
					cnt++;
					max = Math.max(max, cnt);
				}else {
					cnt = 1;
				}
			}
		}
	}
}