import java.util.*;
import java.io.*;
public class Main {
	static boolean[] visit;
	static ArrayList<Integer> lst[];
	static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		lst = new ArrayList[N+1];
		arr = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			lst[i] = new ArrayList<>();
		}
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lst[a].add(b);
			lst[b].add(a);
		}
		dfs(1);
		for(int i=2; i<=N; i++) {
			System.out.println(arr[i]);
		}
    }
    static void dfs(int a) {
		visit[a] = true;
		for(int i : lst[a]){
			if(!visit[i]) {
				dfs(i);
				arr[i] = a;
			}
		}
	}
}