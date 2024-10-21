import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
        	// 공백 출력
            for(int j=1; j<=n-i; j++){         
                sb.append(" ");
            }
            for(int k=1; k<=2*i-1; ++k){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}