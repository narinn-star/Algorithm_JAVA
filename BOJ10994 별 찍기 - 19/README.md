# [10994] 별 찍기 - 19

## 분류
> 구현
>
> 재귀

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10994 {
    private static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int len = 1 + 4 *(N - 1);
        star = new char[len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                star[i][j] = ' ';
            }
        }

        fillStar(0, len);

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillStar(int n, int len){
        if(len <= n) return;

        for(int i = n; i < len; i++){
            star[n][i] = '*'; // 상
            star[i][n] = '*'; // 좌
            star[len - 1][i] = '*'; // 하
            star[i][len - 1] = '*'; // 우
        }

        fillStar(n + 2, len - 2);
    }
}

```

## 문제풀이

재귀 몸풀기로 별찍기를 풀었다.
학부생때는 이런 예제면 기겁을 하고 도망쳤는데, 이젠 물러설곳이 없음

도대체 이 별찍기를 어떻게 재귀로 푸는가를 아주 오래 고민했다. 대충 어떻게 재귀함수를 호출해야할지는 감이 오는데, 빈칸들을 어떻게 채워나가야할지 감이 오지 않았다. 계속 보다보니 가장자리만 별이 채워진 것을 알 수 있었고, 그럼 반복문을 통해서 한 줄씩 다 별로 채우면 되겠다 생각했다. 그렇게 하려면 배열이 필요했고, 배열이라면 모두 빈칸으로 초기화해두면 빈칸이 해결되는 것을 깨닫고 바로 샤샥 풀었다 🤩 
재귀는 종료문을 명확히 작성해둬야 원하는 만큼 돌고 끝나게 되는 것을 명심합시댜
