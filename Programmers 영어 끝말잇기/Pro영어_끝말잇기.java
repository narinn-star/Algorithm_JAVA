import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Pro영어_끝말잇기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        String[] words = new String[101];

        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreElements()){
            words[cnt] = st.nextToken();
            cnt++;
        }
        solution(n,words,cnt); // solution(n, words);
    }
    private static int[] solution(int n, String[] words, int len) { // solution(int n, String[] words)
        int[] answer = {};
        int cnt = 1;

        HashMap<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);

        for(int i = 1; i < len; i++){ // i < words.length
            String str = words[i-1];
            char last = str.charAt(str.length() - 1);

            if(map.containsKey(words[i])){ // 같은 값이 들어오면
                break;
            }
            if(words[i].charAt(0) == last){
                map.put(words[i], i+1);
                cnt++;
            } else {
                break;
            }
        }
        if(len == cnt){ // if(words.length == cnt)
            answer = new int[] {0, 0};
        } else {
            answer = new int[] {cnt%n +1, (cnt/n)+1};
        }
        System.out.println("[" + answer[0] + "," + answer[1] + "]");
        return answer;
    }
}
