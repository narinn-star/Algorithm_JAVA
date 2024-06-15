import java.io.*;
import java.util.StringTokenizer;

public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0;
        int min = Integer.MAX_VALUE;

        while(start <= end && end <= N){
            if(sum < S){
                sum += arr[end++];
            } else if(sum >= S){
                min = Math.min(min, end - start);
                sum -= arr[start++];
            }
        }
        if(min == Integer.MAX_VALUE) bw.write("0" + "\n");
        else bw.write(min + "\n");

        bw.flush();
        bw.close();
    }
}
