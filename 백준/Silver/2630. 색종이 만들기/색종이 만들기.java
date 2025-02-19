import java.util.*;
import java.io.*;
public class Main {
	static int[][] arr;
	static int white = 0;
	static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		square(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
    }
    // 개수 체크
	static void square(int r, int c, int size) {
		if(check(r, c, size)) {
			if(arr[r][c] == 0) white++;
			else blue++;
			return;
		}
		
		int size_2 = size/2; // 절반으로 나누기
		square(r, c, size_2);
		square(r, c+size_2, size_2);
		square(r+size_2, c, size_2);
		square(r+size_2, c+size_2, size_2);
	}
	
	// 색상이 같은지 체크
	static boolean check(int r, int c, int size) {
		int color = arr[r][c];
		
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(color != arr[i][j])
					return false; // 다른색이 하나라도 있다면
			}
		}
		return true; // 모두 같은 경우
	}
}