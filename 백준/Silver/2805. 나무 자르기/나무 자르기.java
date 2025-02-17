import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min, max, mid;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		min = 0; 
        max = 0; 
        
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
            if( max  < arr[i]) max = arr[i];
		}
		
		
		while(min < max) {
			mid = (min+max)/2;
			
			long sum = 0;
			
			for(int i=0; i<arr.length; i++) {
				if(arr[i]-mid > 0)
					sum += arr[i]-mid;
			}
			
			if(sum < M) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		
		System.out.println(min-1);
    }
}