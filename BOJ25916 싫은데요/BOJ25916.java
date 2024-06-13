import java.io.*;
import java.util.StringTokenizer;

public class BOJ25916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, volume = 0;
        int max = Integer.MIN_VALUE;

        while(start < N){
            while(end < N && volume + arr[end] <= M){
                volume += arr[end];
                end++;
            }

            max = Math.max(max, volume);
            volume -= arr[start];
            start++;

        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
