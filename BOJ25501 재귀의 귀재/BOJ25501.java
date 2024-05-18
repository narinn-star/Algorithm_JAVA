import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ25501 {
    private static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] str = new String[T];

        for(int i = 0; i < T; i++){
            str[i] = br.readLine();
            cnt = 0;
            System.out.print(isPalindrome(str[i]));
            System.out.println(" " + cnt);
        }

    }
    private static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    private static int isPalindrome(String s){
        return recursion(s, 0, s.length() - 1);
    }
}
