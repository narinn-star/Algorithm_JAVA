import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1063 {
    private static char[] king, stone;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        king = st.nextToken().toCharArray();
        stone = st.nextToken().toCharArray();
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String direction = br.readLine();
            char[] nextKing = move(direction, king);
            if (checkRange(nextKing)) {
                if (nextKing[0] == stone[0] && nextKing[1] == stone[1]) {
                    char[] nextStone = move(direction, stone);
                    if (checkRange(nextStone)) {
                        king = nextKing;
                        stone = nextStone;
                    } else continue;
                } else king = nextKing;
            } else continue;
        }

        System.out.println(String.valueOf(king[0]) + String.valueOf(king[1]));
        System.out.println(String.valueOf(stone[0]) + String.valueOf(stone[1]));
    }

    private static boolean checkRange(char[] next) {
        if(next[0] < 'A' || next[0] > 'H' || next[1] < '1' || next[1] > '8') return false;
        else return true;
    }

    private static char[] move(String direction, char[] c){
        char[] res = c.clone();
        switch(direction){
            case "R": res[0]++; break;
            case "L": res[0]--; break;
            case "B": res[1]--; break;
            case "T": res[1]++; break;
            case "RB": res[0]++; res[1]--; break;
            case "RT": res[0]++; res[1]++; break;
            case "LB": res[0]--; res[1]--; break;
            case "LT": res[0]--; res[1]++; break;
        }
        return res;
    }
}
