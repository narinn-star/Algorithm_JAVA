import java.io.*;
import java.util.StringTokenizer;

public class BOJ15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        while(start < N){
            while(end < N && cnt < K){
                if(arr[end] == 1) cnt++;

                end++;
            }

            if(cnt == K){
                min = Math.min(min, end - start);
            }

            if(arr[start] == 1) cnt--;
            start++;
        }

        if(min == Integer.MAX_VALUE) {
            bw.write("-1" + "\n");
        }else {
            bw.write(min + "\n");
        }

        bw.flush();
        bw.close();
    }
}
