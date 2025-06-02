import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int n = Integer.parseInt(st.nextToken());
            if(map.containsKey(n)){
                sb.append(map.get(n)+" ");
            }else{
                sb.append("0"+" ");
            }

        }

        System.out.println(sb.toString());
    }
}