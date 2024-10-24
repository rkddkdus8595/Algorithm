import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=n; i++){        	
        	if(i==n) {
        		for(int k=0; k<2*n-1; k++) {
            		sb.append("*");
            	}
        	}else {
        		// 전 공백
            	for(int k=n-1; k>=i; k--) {
            		sb.append(" ");
            	}
        		for(int j=1; j<=2*i-1; j++) {            		
            		if(j==1 || j==2*i-1) sb.append("*");
            		else sb.append(" ");        		
            	}
        	}
        	sb.append("\n");
        }   	
        System.out.print(sb.toString());
    }
}