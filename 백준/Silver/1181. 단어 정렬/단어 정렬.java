import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
		ArrayList<String> lst = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(!lst.contains(str)) {
				lst.add(str);
			}
		}
		
		
		Collections.sort(lst, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				// 길이가 같다면
				if(a.length() == b.length()) {
					return a.compareTo(b);
				}
				return a.length()-b.length();
			}
		});
		
		for(int i=0; i<lst.size(); i++) {
			System.out.println(lst.get(i));
		}
    }
}