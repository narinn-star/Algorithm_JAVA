# [Programmers 다음 큰 숫자] 

## 분류
> 연습문제

## 코드
```java
import java.lang.Integer;
public class Pro다음_큰_숫자 {
        public int solution(int n) {
            int answer = 0;
            String strN = Integer.toBinaryString(n);
            int nCnt = 0;

            for(int i = 0; i < strN.length(); i++){
                if(strN.charAt(i) == '1') nCnt++;
            }

            while(true){
                // 1의 개수가 같으면 break;
                String str = Integer.toBinaryString(++n);
                int cnt = 0;

                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == '1') cnt++;
                }

                if(nCnt == cnt) {
                    answer = n;
                    break;
                }
            }

            return answer;
        }
}
```

## 문제풀이

입력값의 1의 개수를 먼저 세어주고, while문을 돌며 n을 하나씩 더해가면서 각각 1의 개수를 세어준 후 입력값의 1의 개수와 비교해서 같다면 종료해준다.

Integer에 진법 변환 함수들이 꽤나 많은 걸 알게됐다!

이진수에 쫄지 말자,,
