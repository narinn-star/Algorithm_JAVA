import java.io.*;
import java.util.StringTokenizer;

public class BOJ2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];

            if(i == K - 1){
                max = sum;
            }

            if(i >= K){
                sum -= arr[i - K];
                max = Math.max(max, sum);
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
