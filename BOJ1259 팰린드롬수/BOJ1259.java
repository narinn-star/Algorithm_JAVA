import java.util.Scanner;

public class BOJ1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.next();
			StringBuffer sb = new StringBuffer(str);
			String tmp = sb.reverse().toString();
			
			if(str.equals("0")) {
				sc.close();
				return;				
			}
			
			if(str.equals(tmp))
				System.out.println("yes");
			else
				System.out.println("no");
			
		}
	}
}