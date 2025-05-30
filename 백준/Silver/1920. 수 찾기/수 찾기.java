import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int n = Integer.parseInt(st.nextToken());
            if(search(arr, n) != -1){
                sb.append("1").append("\n");
            }else{
                sb.append("0").append("\n");
            }
        }

        System.out.println(sb.toString());

    }
    public static int search(int[] arr, int num){
        int lo = 0;
        int hi = arr.length-1;

        while(lo<=hi){
            int mid = (lo+hi)/2;

            if(arr[mid] > num){
                hi = mid-1;
            }else if(arr[mid] < num){
                lo = mid+1;
            }else if(arr[mid] == num){
                return arr[mid];
            }
        }
        return -1;
    }

}