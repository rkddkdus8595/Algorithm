import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=n; i++){
        	// 전 공백
        	for(int k=n; k>i; k--) {
        		sb.append(" ");
        	}
        	for(int j=0; j<2*i-1; j++) {
        		// 중간 공백
        		if(j%2==0) sb.append("*");
        		if(j%2==1) sb.append(" ");
        	}
        	sb.append("\n");
        }        
        System.out.print(sb.toString());
    }
}