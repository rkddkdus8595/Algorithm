import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cnt = new int[10000+1];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}
		
		br.close();
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<10001; i++) {
			while(cnt[i] > 0) {
				sb.append(i+"\n");
				cnt[i]--;
			}
			
		}
		System.out.println(sb.toString());
    }
}