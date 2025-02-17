import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		long answer = 0;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long min = arr[0];
		long max = arr[arr.length-1]+K;
		
		while(min <= max) {
			long mid = (min+max)/2;
			
			long sum = 0;
			
			for(int i=0; i<arr.length; i++) {
				if(mid > arr[i]) sum += mid-arr[i];
			}
			if( K >= sum) {
				answer = Math.max(answer, mid);
				min = mid+1;
			}else {
				max = mid-1;
			}
		}
        System.out.println(answer);
    }
}