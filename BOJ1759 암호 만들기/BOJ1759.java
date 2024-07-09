import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    static int L, C;
    static char[] alpha, resCode;
    static boolean[] check;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new char[C];
        resCode = new char[L];
        check = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            alpha[i] = Character.valueOf(st.nextToken().charAt(0));
        }

        Arrays.sort(alpha);

        dfs(0, 0);

        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int start)throws IOException{
        if(depth == L){
            if(checkAlpha()){
                for(char c : resCode) bw.write(c + "");
                bw.write("\n");
            }
            return;
        }

        for(int i = start; i < C; i++){
                resCode[depth] = alpha[i];
                dfs(depth + 1, i + 1);
        }
    }

    static boolean checkAlpha(){
        int consonantsCnt = 0;
        int vowelCnt = 0;

        for(char c : resCode) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowelCnt++;
            else consonantsCnt++;
        }

        if(vowelCnt >= 1 && consonantsCnt >= 2) return true;
        else return false;
    }
}
