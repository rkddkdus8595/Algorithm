import java.util.*;
import java.io.*;
public class Main {
	static int N, answer;
	static boolean[] visit;
	static int[] arr;
	static int[] temp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visit = new boolean[N];
		temp = new int[N];
		ArrayList<Integer> lst = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(answer);
    }
    static void dfs(int depth) {
		if(depth == N) {
            int sum = 0;
            for(int i=0; i<N-1; i++) {
                 sum += Math.abs(temp[i]-temp[i+1]);
            }
			answer = Math.max(answer, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				temp[depth] = arr[i];
				visit[i] = true;
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}
}