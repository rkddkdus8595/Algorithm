import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> lst = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
        
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			int num = Integer.parseInt(str);
			lst.add(num);
		}
		Collections.sort(lst);
		for(int i=0; i<lst.size(); i++) {
            sb.append(lst.get(i)+"\n");
		}
        System.out.println(sb.toString());
    }
}