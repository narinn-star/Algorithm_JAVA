# [1439] 뒤집기

## 분류
> 그리디 알고리즘
> 
> 문자열

## 코드
```java
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
```

## 문제풀이

항상 손으로 풀기 쉬운 문제들이 접근하기가 조금 무서운 것 같다.. 사람이 생각하는 방식을 컴퓨터가 생각하는 방식으로 바꿔야한다는 생각때문인지 지레 겁먹는다.

결론은 문제는 쉽게 풀었다. 0으로 바꿀 때와 1로 바꿀 때의 카운트 수를 비교해서 작은 수를 출력했다. 
어차피 길이도 100만보다 작기도 했고, 두 번 반복문 도는 것정도는 시간이 충분하다 생각했기 때문이다. 더 좋은 방법이 있을까 찾아봤는데 거의 비슷했다.
딱 한가지 신기한 풀이를 봤는데, StringTokenizer를 사용하는 방법이다. 나는 줄곧 입력받을 때만 StringTokenizer를 사용해왔는데, 0과 1로 잘라 countTokens()라는 메소드를 가지고 0 토큰 개수, 1 토큰 개수를 세어 작은 수를 찾으면 된다는... 충격적인 풀이였다.

아직 실버를 풀어도 얻을 게 많다는 점..✨
