import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		sb.append("<");
		while(que.size() > 1) {
			for(int i=0; i<K-1; i++) {
				int num = que.poll();
				que.offer(num);
			}
			sb.append(que.poll()+", ");
		}
		
		sb.append(que.poll()+">");
		System.out.println(sb.toString());
    }
}