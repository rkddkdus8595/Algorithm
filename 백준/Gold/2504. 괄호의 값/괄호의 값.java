import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stk = new Stack<>();
		int sum = 0;
		int mul = 1;
		
		String str = br.readLine();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '(') {
				stk.push(c);	
				mul *= 2;
			}else if(c== '[') {
				stk.push(c);
				mul *= 3;
			}else { // 닫는 괄호
				if(c==')') {
					if(stk.isEmpty() || stk.peek() != '(') {
						sum = 0;
						break;						
					}
					if(str.charAt(i-1) == '(') {
						sum += mul;
					}
					stk.pop();
					mul /= 2;
				}else if(c==']') {
					if(stk.isEmpty() || stk.peek() != '[') {
						sum = 0;
						break;						
					}
					if(str.charAt(i-1) == '[') {
						sum += mul;
					}
					stk.pop();
					mul /= 3;
				}
			}
		}
		if(!stk.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(sum);
		}
    }
}