import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		int sum = 0;
		int a = -1, b = -1;
		for(int i=0; i<9; i++) {
			int N = Integer.parseInt(br.readLine());
			arr[i] = N;
			sum += N;
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(sum-arr[i]-arr[j] == 100) {
					a=i;
					b=j;
					break;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(i == a || i == b) continue;
			System.out.println(arr[i]);
		}
    }
}