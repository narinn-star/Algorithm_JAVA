import java.io.*;
import java.util.StringTokenizer;

public class BOJ20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] cnt = new int[100001];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;

        while(right < N){
            while(right < N && cnt[arr[right]] + 1 <= K) {
                cnt[arr[right]]++;
                right++;
            }
            max = Math.max(max, right - left);
            cnt[arr[left]]--;
            left++;
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
