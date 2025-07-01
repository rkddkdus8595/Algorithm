import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int Z = (int) ((long) Y*100 / X);

        int left = 0;
        int right = (int)1e9;
        int ans = -1;
        while(left <= right){
            int mid = (left+right)/2;
            int rate = (int) ((long) (Y+mid)*100 / (X+mid));
            if( rate > Z){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        System.out.println(ans);
    }

}