import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int[] arr;
		for(int i=0; i<C; i++) {
			int N = sc.nextInt(); // 학생 수
			arr = new int[N];
			double sum = 0; // 합계
			double avg = 0; // 평균
			
			for(int j=0; j<N; j++) {
				int score = sc.nextInt();
				arr[j] = score;
				sum+=score;
			}
			avg = sum/N;
			double avg_num = 0; // 평균을 넘는 학생 수
			for(int j=0; j<N; j++) {
				if(arr[j] > avg) avg_num++;
			}
			System.out.println(String.format("%.3f%%", (avg_num/N)*100));
		}
    }
}