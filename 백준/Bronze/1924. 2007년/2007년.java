import java.util.*;
public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        String [] Day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int a = sc.nextInt(); 
        int b = sc.nextInt();
        cal.set(2007, a-1, b); // 월이 0 부터 시작이라 -1 셋팅        
        System.out.println(Day[cal.get(Calendar.DAY_OF_WEEK)-1]);
        
    }
}