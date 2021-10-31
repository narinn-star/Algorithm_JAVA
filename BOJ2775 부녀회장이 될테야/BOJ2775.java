import java.util.Scanner;

public class BOJ2775 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};	//0Ãþ °ÅÁÖ¹Î ¼ö
			int res = 0;
			
			if(n == 1)
				res = arr[0];
			else {
				for(int j = 1; j < arr.length; j++) {
					for(int l = 1; l <k; l++) {
						arr[j] = arr[0] + arr[j];
						res = arr[j];						
					}
				}
			}
			System.out.println(res);
		}
		
		
		sc.close();
	}

}
