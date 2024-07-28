import java.io.*;

public class BOJ5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int res = 0;

        for (int i = 0; i < M - 2; i++) {
            if (S.charAt(i) == 'I') {
                int cnt = 0;

                while (i + 2 < M && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                    cnt++;
                    i += 2;

                    if (cnt == N) {
                        res++;
                        cnt--;
                    }
                }
            }
        }

        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
