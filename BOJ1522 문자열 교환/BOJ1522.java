import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int aCnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a') aCnt++;
        }

        if(aCnt == 0) {
            System.out.println(0);
            return;
        }

        for(int i = 0; i < aCnt; i++){
            str += str.charAt(i);
        }

        int bCnt = 0;
        for(int i = 0; i < aCnt; i++){
            char c = str.charAt(i);
            sb.append(c);
            if(c == 'b') bCnt++;
        }

        int min = bCnt;

        for(int i = aCnt; i < str.length(); i++){
            if(sb.substring(0, 1).charAt(0) == 'b') bCnt--;

            sb.deleteCharAt(0);
            sb.append(str.charAt(i));

            if(str.charAt(i) == 'b') {
                bCnt++;
            }
            min = Math.min(min, bCnt);

        }

        System.out.println(min);
    }
}
