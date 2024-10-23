import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=n; i++){
            for(int k=1; k<i; k++) {
            	sb.append(" ");
            }
            for(int j=1; j<=2*(n-i)+1; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        
        for(int i=n-1; i>0; i--) {
        	for(int k=1; k<i; k++) {
            	sb.append(" ");
            }
            for(int j=1; j<=2*(n-i)+1; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        
        System.out.print(sb.toString());
    }
}