import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<int[]> stk = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			int number = Integer.parseInt(st.nextToken());
			while(!stk.isEmpty()) {
				if(stk.peek()[1] >= number) {
					sb.append(stk.peek()[0]+" ");
					break;
				}
				stk.pop();
			}
			if(stk.isEmpty())
				sb.append("0 ");
			
			stk.push(new int[] {i+1, number});
		}
		
		System.out.println(sb.toString());
    }
}