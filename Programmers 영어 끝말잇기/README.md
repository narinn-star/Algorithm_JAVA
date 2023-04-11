# [Programmers 영어 끝말잇기]

## 분류
> Summer/Winter Coding(~2018)

## 코드
```javaimport java.io.BufferedReader;
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
```

## 문제풀이

'등장했던 단어 사용 불가' 라는 것을 읽자 마자 map으로 체크 해야겠구나 했다.
문제를 풀기 시작하면서 생각이 다른 곳으로 샌건지, map으로 하지 않아도 되겠구나 싶었던건지 map을 쓰지도 않고 냅다 문자열로 비교를 하려 했다... map을 까맣게 잊고서는.. 
한참 풀다 너무 복잡해져서 코드를 다 지우고 다시 노트를 봤는데 map이 쓰여져 있었고(ㅠㅠ), HashMap을 사용해서 다시 풀었다. 
containesKey 함수가 떠오르지 않아서 구글링 1회,
answer 배열에 값이 안들어가서 구글링 1회, (new int[]가 없었..)
answer 배열 첫번째 값 계산이 안되서 구글링 1회 했다.. (%가 떠오르질 않았다..)

여전히 문제는 크게 어렵지 않았지만, IDE 없이 풀어내려니 그동안 IDE에 의존했던 것이 아주 컸던 게 느껴졌다.
위의 코드는 programmers에 제출한 답안이 정상적으로 돌아가게 하기 위해 조금 수정(추가)한 코드이다.
