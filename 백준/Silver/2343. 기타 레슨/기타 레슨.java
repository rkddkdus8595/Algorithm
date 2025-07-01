import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static int[] arr;
    static int left, right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i]; // 크기 합
            left = Math.max(arr[i], left); // 최대 값
        }
        System.out.println(binarySearch(left, right));
    }
    public static int binarySearch(int left, int right){
        while(left <= right){
            int mid = (left+right)/2;
            int sum = 0; // 강의 시간 합
            int count = 1; // 블루레이 개수

            // 몇개의 블루레이 나오는지 체크하기
            for(int i=0; i<arr.length; i++){
                sum += arr[i];
                if(sum > mid){
                    sum = arr[i];
                    count++;
                }
            }
            // 블루레이 개수가 작다면 상한값 내리기 (용량을 줄여야함)
            if(count <= M){
                right = mid-1;
            }else{
                left = mid+1;
            }

        }
        return left;
    }

}