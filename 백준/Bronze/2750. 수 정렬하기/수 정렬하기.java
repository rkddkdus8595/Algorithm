import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		List<Integer> lst = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			lst.add(sc.nextInt());
		}
		Collections.sort(lst);
		for(int i=0; i<lst.size(); i++) {
			System.out.println(lst.get(i));
		}
    }
}