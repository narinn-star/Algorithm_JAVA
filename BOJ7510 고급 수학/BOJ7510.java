import java.util.Arrays;
import java.util.Scanner;

public class BOJ7510 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] length = new int[3];
		
		for(int i = 1; i <= n; i++) {
			String res = "no";
			for(int j = 0; j < 3; j++) {
				length[j] = sc.nextInt();				
			}
			Arrays.sort(length);
			if(length[2]*length[2] == length[0]*length[0] + length[1]*length[1])
				res = "yes";
			System.out.println("Scenario #" + i +":");
			System.out.println(res);
			System.out.println();
		}
		sc.close();
	}

}
