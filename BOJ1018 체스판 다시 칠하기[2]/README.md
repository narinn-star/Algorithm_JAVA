# [2475] 검증수

## 분류
> 브루트포스 알고리즘

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {
    public static char board[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        int max = 64;

        board = new char[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < N-7; i++){
            for(int j = 0; j < M-7; j++){
                count = paint(i, j);
                if(max > count) max = count;
            }
        }
        System.out.println(max);
    }
    public static int paint(int a, int b) {
        String boardSample1[] = {"WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW","WBWBWBWB", "BWBWBWBW"};
        String boardSample2[] = {"BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB","BWBWBWBW", "WBWBWBWB","BWBWBWBW", "WBWBWBWB"};
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = a; i <= a + 7; i++){
            for(int j = b; j <= b + 7; j++){
                if(boardSample1[i-a].charAt(j-b) != board[i][j]) {
                    cnt1++;
                }
                if(boardSample2[i-a].charAt(j-b) != board[i][j]) {
                    cnt2++;
                }
            }
        }
        return Math.min(cnt1, cnt2);
    }
}

```

## 문제풀이

생각해야할 문제
1. 8x8로 떼어내기
2. 떼어낸 판을 비교하기
3. 최소 카운트 찾아내기

참고할 예제는 2번으로 했다.

10 13
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB

1. 우선 입력받은 체스판에서 8x8로 뗴어내기 위해서는 넘치거나 모자라지 않아야하는 것에 집중을 하면 떠올릴 수 있다. 가로는 0~7,1~8,2~9,3~10,4~11,5~12 와 같이 반복되어야 하고, 세로는 0~7,1~8,2~9,3~10 와 같이 반복되어야 한다.
즉, 탐색의 시작이 되는 수는 0,1,2,3,4,5(가로) 0,1,2,3(세로)이 되고 이는 0부터 n(또는 m)-7인 것을 찾아낼 수 있다.

2. 탐색의 시작 (i, j)를 함수의 인자로 넘겨 이제 8x8로 떼어내기만 하면 된다. 당연히 i부터 i+7까지 반복하면 8개씩 떼어낼 수 있다. 

비교도 너무 어렵지 않게 생각해야한다. 우리가 비교할 완성된 체스판은 두가지 뿐이다. (0,0)자리가 흰색이거나 검정색이거나. 나는 미리 배열을 만들어 두었다. 어차피 다른 경우의 수는 없기 때문이다.

8개씩 떼어내어 비교할 때 주의할 점은 인자로 받은 수 두개는 8 이상이지만 내가 만들어둔 샘플보드는 절대 8을 넘기지 않기 때문에 비교할 때 `boardSample1[i-a].charAt(j-b)`와 같이 인덱스 계산을 해주어야 한다는 것이다.

3. 두개 모두 비교를 하면서 다른 부분이 있을 때만 따로 카운팅을 해준 후, 모든 반복이 끝났을 때 두 카운팅 값 중 작은 값을 리턴하면 된다.

우리가 구하는 체스판은 8x8로, 최대 cnt 값은 64를 넘길 수 없기 때문에 최대값을 설정해두었다. 매번 함수에서 카운팅 값을 리턴할 때마다 max값을 최소값으로 저장해주고 max를 출력하면 된다.
