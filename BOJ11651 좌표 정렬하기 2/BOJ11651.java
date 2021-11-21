import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11651 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
				arr[i][0] = Integer.parseInt(str[0]);
				arr[i][1] = Integer.parseInt(str[1]);
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[1] == o2[1])
				return Integer.compare(o1[0], o2[0]);
			else
				return Integer.compare(o1[1], o2[1]);
		});
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		br.close();
	}

}
