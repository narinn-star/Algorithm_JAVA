import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;

        while(start < N){
            if(arr[end] - arr[start] < M){
                end++;
            }else{
                min = Math.min(min, arr[end] - arr[start]);
                start++;
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}
