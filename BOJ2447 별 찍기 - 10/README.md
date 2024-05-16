# [2447] 별 찍기 - 10

## 분류
> 분할 정복
>
> 재귀

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2447 {
    private static int N;
    private static String[][] star;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        star = new String[N][N];
        sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            Arrays.fill(star[i], " ");
        }

        printStar(0,0, N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void printStar(int x, int y, int size){
        if (size == 1) {
            star[x][y] = "*";
            return;
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 1 && j == 1) continue;
                printStar(x + i * (size / 3), y + j  * (size / 3), size / 3);
            }
        }
    }
}
```

## 문제풀이

별찍기 19보다 쉬웠다. 재귀가 조금 몸에 익었나... 
19는 한 줄씩 자리를 찾아줬다면, 이번엔 가운데가 비어있는 3x3 별 모양을 재귀로 찍어내면 된다고 생각해서 바로 작성할 수 있었다. size가 1일 때는 별 하나를 찍고 재귀를 종료하고, 3의 거듭제곱일 때는 가운데가 비어있는 3x3별을 계속해서 찍어주면 된다. 시작점과 사이즈만 잘 정리해서 재귀를 호출하면 잘 찍힘! 
가운데가 비어있는 것은 (1, 1)자리이기 때문에 i, j가 1일때는 호출하지 않았다. 

설명을 하고나니 조금 복잡해보이긴 한데, 예제 입력값이 27일 때, 출력값의 맨 윗줄은 27개로 배열이 27x27이지만, 3x3 별을 한 세트로 생각하면 9x9모양인 것이다. 즉, 3x3짜리 별을 한 좌표로 생각하고 풀었다..

다른 풀이를 보니 boolean 체크를 통해 하는 것 같았는데.. 내 머리로는 이게 더 쉬워욤.. 여러 블로그 중에 딱 한분이 나랑 똑같이 푼 분이 있었다. (다행이라 생각했다.. 내가 틀린 생각을 한 게 아니어서😅)

다만, StringBuilder를 처음에 사용하지 않아서 시간 초과가 났다는 것인데, 제출하기 전에 어떻게 시간 계산을 해서 StringBuilder를 써야겠다 생각할 수 있을지 잘 모르겠다..

