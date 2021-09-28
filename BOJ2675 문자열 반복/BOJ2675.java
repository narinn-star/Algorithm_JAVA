import java.util.Scanner;

public class BOJ2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
 			int R = sc.nextInt();
			 
			String S = sc.next();
			for(int r = 0; r < S.length(); r++) {
				for(int i = 0; i < R; i++) {
					System.out.print(S.charAt(r));
				}
			}
		}
		
		sc.close();
	}
}