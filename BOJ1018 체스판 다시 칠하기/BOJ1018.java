import java.util.Scanner;

public class BOJ1018 {
	static char[][] chess;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 0;
		int res = 64;
		
		chess = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			for(int j = 0; j < m; j++) {
				chess[i][j] = str.charAt(j);
			}
		}
		for(int i = 0; i < n-7; i++){
			for(int j = 0; j < m - 7; j++) {
				cnt = find(i, j);
				if(res > cnt)
					res = cnt;
			}
		}
		System.out.println(res);
	}
	
	public static int find(int a, int b) {
		int cnt1 = 0;
		int cnt2 = 0;
		String[] board1 = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW"};
		String[] board2 = {"BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB"};
		
		for(int i = a; i < a+8; i++) {
			for(int j = b; j < b+8; j++) {
				if(chess[i][j] != board1[i - a].charAt(j-b))
					cnt1++;
				if(chess[i][j] != board2[i - a].charAt(j-b))
					cnt2++;
			}
		}
		return Math.min(cnt1, cnt2);
	}
}