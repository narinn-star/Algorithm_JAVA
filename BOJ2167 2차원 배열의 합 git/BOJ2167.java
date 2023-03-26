import java.io.*;
import java.util.StringTokenizer;

public class BOJ2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); 

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1]; //기본 배열 선언

        for(int i = 1; i <= n; i++){ //문제에서 (0,0)부터가 아니라 (1,1)부터로 계산하도록 했으니, 편의를 위해 1부터 반복
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken()); //배열 채우기
            }
        }

        int k = Integer.parseInt(br.readLine());

        for(int l = 0; l < k; l++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());  
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int sum = 0;    //출력할 값

            for (int a = j; a <= y; a++) {
                for (int b = i; b <= x; b++) {
                    sum += arr[b][a];   //세로로 반복해야하니까!
                }
            }
            System.out.println(sum);
        }
    }
}
