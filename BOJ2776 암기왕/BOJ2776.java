import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            int[] note1 = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                note1[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1);
            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                int min = 0, max = N, mid;

                int findNum = Integer.parseInt(st.nextToken());
                boolean find = false;

                while(min <= max) {
                    mid = (min + max) / 2;

                    if(note1[mid] == findNum){
                        find = true;
                        break;
                    }
                    else if(note1[mid] < findNum) min = mid + 1;
                    else max = mid - 1;
                }
                sb.append(find ? 1 : 0).append("\n");
            }

            System.out.print(sb);
        }
    }
}
