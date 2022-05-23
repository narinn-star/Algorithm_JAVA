import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
	public static int white = 0;
	public static int blue = 0;
	public static int[][] paper;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	public static void find(int row, int col, int size) {	
		if(check(row, col, size)) {
			if(paper[row][col] == 0)
				white++;
			else
				blue++;
			return;
		}
		
		int Size = size / 2;
		find(row, col, Size);
		find(row, col + Size, Size);
		find(row + Size, col, Size);
		find(row + Size, col + Size, Size);
	}
	public static boolean check(int row, int col, int size) {
		int color = paper[row][col];
		
		for(int i = row; i < row + size; i++) {
			for(int j = col; j < col + size; j++) {
				if(paper[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}