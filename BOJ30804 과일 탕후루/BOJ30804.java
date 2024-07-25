import java.io.*;
import java.util.StringTokenizer;

public class BOJ30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] tang = new int[N];
        int[] num = new int[10];
        int kind = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tang[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int cnt = 0, max = 0;

        while(right < N) {
            if(num[tang[right]] == 0){
                kind++;
            }

            cnt++;
            num[tang[right]]++;

            if(kind > 2){
                if(--num[tang[left]] == 0){
                    kind--;
                }
                cnt--;
                left++;
            }
            max = Math.max(max, cnt);
            right++;

        }

        bw.write(max + "");
        bw.flush();
        bw.close();

    }
}
