import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> que = new LinkedList<>();
		
		int number = Integer.parseInt(br.readLine());
		for(int i=1; i<=number; i++) {
			que.add(i);
		}
		while(que.size() != 1) {
			que.poll();
			int num = que.poll();
			que.add(num);
		}
		System.out.println(que.peek());
    }
}