import java.io.*;

public class BOJ1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        int cnt1 = 0, cnt2 = 0;

        // 1로 바꾸기
        for(int i = 0; i < S.length() - 1; i++){
            if(S.charAt(0) == '0') cnt1++;
            if(S.charAt(i) == '1' && S.charAt(i + 1) == '0') cnt1++;
        }

        // 0으로 바꾸기
        for(int i = 0; i < S.length() - 1; i++){
            if(S.charAt(0) == '1') cnt2++;
            if(S.charAt(i) == '0' && S.charAt(i + 1) == '1') cnt2++;
        }

        bw.write(Math.min(cnt1, cnt2) + "\n");
        bw.flush();
        bw.close();
        br.close();


    }
}
