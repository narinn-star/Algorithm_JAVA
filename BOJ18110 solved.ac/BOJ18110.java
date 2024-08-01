import java.io.*;
import java.util.Arrays;

public class BOJ18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int except = (int)Math.round(N * 0.15);
        int all = N - (except * 2);
        double sum = 0;
        for(int i = except; i < N - except; i++){
            sum += arr[i];
        }

        bw.write(Math.round(sum / all) +"");
        bw.flush();
        bw.close();
        br.close();
    }
}
