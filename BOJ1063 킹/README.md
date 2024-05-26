# [1063] 킹

## 분류
> 구현
> 
> 시뮬레이션

## 코드
```java
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

```

## 문제풀이

필요한 함수는 총 두개로 다음과 같다. 
- 범위를 체크하는 함수
- 말을 이동하는 함수

킹과 돌 모두 범위 체크 / 이동이 필요하지만 어차피 함수 같은 걸로 모두 체크 가능하기 때문에 매개변수만 잘 넘겨주면 된다. 숫자나 char이나 ++ --로 충분히 값을 자유롭게 바꿔줄 수 있어서 편했다. 
진행은 다음과 같다.
방향 입력 -> 킹 이동 -> 킹 범위 체크 -> 킹 이동 예정 위치에 돌이 있는지 체크 -> 돌 이동 -> 돌 범위 체크 -> 킹, 돌 값 갱신 

범위가 알맞지 않을 경우에는 알맞게 킹만 갱신해주거나 아예 넘어가면 된다.

어렵지 않은 구현 문제!
