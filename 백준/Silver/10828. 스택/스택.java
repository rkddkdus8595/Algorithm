import java.util.*;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			if( str.equals("push")) {
				stk.add(Integer.parseInt(st.nextToken()));
			}else if(str.equals("pop")) {
				if(stk.isEmpty()) 
                    sb.append(-1).append("\n");
				else 
                    sb.append(stk.pop()).append("\n");
			}else if(str.equals("size")) {
				sb.append(stk.size()).append("\n");
			}else if(str.equals("empty")) {
				if(stk.isEmpty()) 
                    sb.append(1).append("\n");
				else 
                    sb.append(0).append("\n");
			}else if(str.equals("top")) {
				if(stk.isEmpty()) 
                    sb.append(-1).append("\n");
				else 
                    sb.append(stk.peek()).append("\n");
			}
		}
		System.out.print(sb.toString());
    }
}