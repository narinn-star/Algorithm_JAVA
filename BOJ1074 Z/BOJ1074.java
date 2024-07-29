import java.io.*;
import java.util.StringTokenizer;

public class BOJ1074 {
    static int r, c, res = 0;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        z(0, 0, (int)Math.pow(2, N)); // 0, 0 ~ 2^N, 2^N
    }

    static void z(int x, int y, int len)throws IOException{
        if(len == 1) {
            bw.write(res + "");
            bw.flush();
            bw.close();
            return;
        }

        int newLen = len / 2;

        if(r < x + newLen && c < y + newLen){ // 1 왼쪽 위
            res += 0;
            z(x, y, newLen);
        }else if(r < x + newLen && c >= y + newLen){ // 2 오른쪽 위
            res += (len * len) / 4;
            z(x, y + newLen, newLen);
        }else if(r >= x + newLen && c < y + newLen){ // 3 왼쪽 아래
            res += ((len * len) / 4) * 2;
            z(x + newLen, y, newLen);
        }else if(r >= x + newLen && c >= y + newLen){ // 4 오른쪽 아래
            res += ((len * len) / 4) * 3;
            z(x + newLen, y + newLen, newLen);
        }
    }
}
