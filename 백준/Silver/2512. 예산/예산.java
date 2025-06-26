import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 1. 정렬
        Arrays.sort(arr);

        // 2. 반복
        int left = 0;
        int right = arr[N-1];

        while(left <= right){
            int mid = (left+right)/2;
            long money = 0;

            for(int i=0; i<N; i++){
                if(arr[i] < mid) money += arr[i];
                else money += mid;
            }

            if(money <= M){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(right);
    }

}