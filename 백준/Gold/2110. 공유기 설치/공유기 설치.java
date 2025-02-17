import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		int min, max, mid;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		Arrays.sort(arr);

		min = 1;
		max = arr[arr.length-1]-arr[0]+1;
		
		while(min < max) {
			mid = (min+max)/2;
			
			int cnt = 1;
			int last = arr[0]; // 마지막으로 설치한 위치 저장
			
			for(int i=1; i<arr.length; i++) {
				int cur = arr[i];
				
				if(cur-last >= mid) {
					cnt++;
					last = cur;
				}
			}
            if(cnt < C) {
					max = mid;
            }else {
                min = mid+1;
            }
		}
		
		System.out.println(min-1);
    }
}