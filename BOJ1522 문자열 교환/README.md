# [1522] 문자열 교환

## 분류
> 브루트포스 알고리즘
> 
> 슬라이딩 윈도우

## 코드
```java
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

```

## 문제풀이

a가 연달아 나오려면 b를 옮기거나 a를 옮기거나 둘 중 하나인데, 중요한 건 어떤걸 어디로 옮기느냐는 전혀 신경쓸 필요가 없다는 거다. 

a가 연달아 있으려면 a의 갯수만큼 쭉- 연달아 위치할 것이므로, a의 갯수를 먼저 세어준다. 그리고 그 갯수를 범위로 해서 str을 돌며 b의 갯수를 갱신해주고 min값도 갱신한다. 

문자열 앞을 짜르고 붙이고 하는 과정은 StringBuilder를 사용했다. substring으로 짤라주고, deleteCharAt()을 사용해서 맨 앞자리를 없애줬다. 
