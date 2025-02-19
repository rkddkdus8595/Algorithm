import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stk = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			boolean flag = true;
			String str = br.readLine();
			stk = new Stack<>();
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j)=='(')
					stk.push(str.charAt(j));
				else if(stk.isEmpty()) {
						flag = false;
						break;
				}else {
					stk.pop();
				}
			}
			if(stk.empty() && flag) System.out.println("YES");
			else System.out.println("NO");
		}
    }
}