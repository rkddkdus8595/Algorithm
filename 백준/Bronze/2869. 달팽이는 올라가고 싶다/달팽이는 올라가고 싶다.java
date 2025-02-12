import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken()); // 낮에 올라가는 높이
		int B = Integer.parseInt(st.nextToken()); // 미끄러지는 높이
		int V = Integer.parseInt(st.nextToken()); // 총 나무 막대 높이
		
		// 하루동안 올라간 높이 A-B
		int day = (V-B) / (A-B); // 오르기 전날
		if((V-B)%(A-B) != 0) { // 나머지 블록 있으면 하루 더 소요
			day++;
		}
        System.out.println(day);
    }
}