import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			if( n == 0) {
				if(pq.isEmpty()) sb.append("0\n"); 
				else sb.append(pq.poll()+"\n");
			}else {
				pq.offer(n);	
			}
		}
		
		System.out.println(sb.toString());
    }
}