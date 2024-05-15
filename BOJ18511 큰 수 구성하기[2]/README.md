# [18511] 큰 수 구성하기

## 분류
> 브루트포스 알고리즘
>
> 재귀

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18511_2 {
    private static int N, K, res = 0;
    private static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[K];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        findBig(0);
        System.out.println(res);
    }

    private static void findBig(int currentNum){
        if(currentNum > N) return;
        if(res < currentNum) res = currentNum;

        for(int i = 0; i < K; i++){
            findBig((currentNum * 10) + num[i]);
        }
    }
}
```

## 문제풀이

어제까지 풀었던 재귀 문제들(별찍기19, 종이의 개수)이 생각보다 어려웠어서 다시 쉬운 문제로 내려왔다 ..

그래도 쉬운 문제라고 그나마 빨리 풀긴 했는데, 천천히 손으로 직접 슈도코드를 작성해보고 나서 작성해서 그런지 조금 수월하게 느껴졌다.

처음 고민한 것은 만들 수 있는 숫자의 크기를 어떻게 세자리수(입력이 657이라는 가정 하에)로 맞추는가 였다. 왜냐하면 1, 5, 7로 만들 수 있는 수는 무궁무진한데 657 보다 작은수를 만들기 위해서는 자릿수먼저 맞춰야한다 생각했기 때문이다. 그래서 0부터 하나씩 올라가는 것이 맞다고 판단했다. (예제가 N의 최댓값에 가까운 값이면 나눗셈을 해도 될 듯한데, 그렇게 하면 조금 수식이 귀찮아질 것 같다.)
0부터 N보다 큰지 작은지 판단 후, 결과값이 될 res에 담아두고 숫자를 만들어갔다. 두번째 조건문 아래에 res를 출력해보면 0 -> 1 -> 11 -> 111 -> 115 -> 117 -> 117 -> 151 -> ,,, -> 577이 나온다. 적절한 return 조건문과 반복문을 통해 브루트포스 탐색이 되고 currentNum이 N보다 크면 res를 갱신하지 않고 그 이전 값이 res에 저장되어있기 때문에 577이 나오게 된다.
