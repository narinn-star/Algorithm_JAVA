# [15961] 회전 초밥

## 분류
> 두 포인터
>
> 슬라이딩 윈도우

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] plate = new int[N + k];
        int[] sushi = new int[d + 1];

        for (int i = 0; i < N; i++) {
            plate[i] = Integer.parseInt(br.readLine());
        }

        // 원형으로 만들어주기
        for (int i = 0; i < k; i++) {
            plate[N + i] = plate[i];
        }

        int cnt = 0;

        // 처음 k개 먼저 계산
        for (int i = 0; i < k; i++) {
            if (sushi[plate[i]] == 0) {
                cnt++;
            }
            sushi[plate[i]]++;
        }

        if (sushi[c]++ == 0) cnt++;

        int max = cnt;

        for (int i = k; i < plate.length; i++) {
            sushi[plate[i - k]]--;
            if (sushi[plate[i - k]] == 0) cnt--;

            if (sushi[plate[i]]++ == 0) {
                cnt++;
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}

```

## 문제풀이

원형으로 어떻게 만들지 모르겠어서 k개만큼 더 배열에 넣어줬다.
처음 0부터 k만큼 먼저 max값을 구해두고 시작했다. 그리고 쿠폰으로 먹을 수 있는 스시도 미리 계산한 후에 반복문을 실행했다.

그리고 반복문에서 빼주는 값이 0이면 다시 초밥 갯수를 빼주고, 더해주는 값이 0이면 초밥 갯수를 더해주고난 후에 max값을 구해줬다.

쿠폰 스시는 어차피 내부에서 구해줘도 계속 빼주고 더해줘야할 것 같아서, 처음에 먼저 더해주고 시작했다.

처음엔 cnt값을 k + 1개로 시작해서 반대로 생각했는데, 이게 더 직관적이긴 한 듯 하다.
