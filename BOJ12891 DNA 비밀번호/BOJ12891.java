import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12891 {
    private static int[] minChar, tmpMinChar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] dna = new char[S];
        String str = br.readLine();
        for(int i = 0; i < S; i++){
            dna[i] = str.charAt(i);
        }

        minChar = new int[4]; // { A, C, G, T }
        tmpMinChar = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0, n = minChar.length; i < n; i++){
            minChar[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for(int i = 0; i < P; i++){
            if(dna[i] == 'A') tmpMinChar[0]++;
            else if(dna[i] == 'C') tmpMinChar[1]++;
            else if(dna[i] == 'G') tmpMinChar[2]++;
            else if(dna[i] == 'T') tmpMinChar[3]++;
        }

        if(checkDna()) cnt++;

        for(int i = P; i < S; i++){
            int idx = i - P;
            if(dna[idx] == 'A') tmpMinChar[0] --;
            else if(dna[idx] == 'C') tmpMinChar[1]--;
            else if(dna[idx] == 'G') tmpMinChar[2]--;
            else if(dna[idx] == 'T') tmpMinChar[3]--;

            if(dna[i] == 'A') tmpMinChar[0]++;
            else if(dna[i] == 'C') tmpMinChar[1]++;
            else if(dna[i] == 'G') tmpMinChar[2]++;
            else if(dna[i] == 'T') tmpMinChar[3]++;

            if (checkDna()) cnt++;
        }

        System.out.println(cnt);

    }
    private static boolean checkDna(){
        for(int i = 0; i < 4; i++){
            if(tmpMinChar[i] < minChar[i]) return false;
        }
        return true;
    }
}
