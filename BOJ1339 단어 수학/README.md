# [1339] 단어 수학

## 분류
> 그리디 알고리즘

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N + 1];
        int[] alpha = new int[26];

        for(int i = 0; i < N; i++){
            words[i] = br.readLine();
        }

        for(int i = 0; i < N; i++){
            int order = (int)Math.pow(10, words[i].length() - 1);
            for(int j = 0; j < words[i].length(); j++){
                int idx = words[i].charAt(j) - 65;
                alpha[idx] += order;
                order /= 10;
            }
        }

        Arrays.sort(alpha);
        int max = 9;
        int sum = 0;
        for(int i = alpha.length - 1; i >= 0; i--){
            if(alpha[i] == 0) break;
            sum += alpha[i] * max;
            max--;
        }

        System.out.println(sum);
    }
}
```

## 문제풀이

문제를 보고 처음 든 생각은 바로 알파벳 배열 만들기. 아스키코드를 기반으로 알파벳 배열을 만들어두면 생각보다 풀 수 있는 문제가 많았던 기억이 있어서, 바로 만들 수 있었다. 

그 다음은 가장 긴단어의 맨앞 글자가 가장 큰 숫자를 가져야한다는 것인데, 이는 문자열 길이를 가져와서 바로 적용할 수 있었다. 10의 배수를 만들어 주기 위해서 Math.pow()함수를 사용했고, 10부터 시작이니까 length에서 -1을 해줬다. 그럼 0일땐 1이 나오게 돼서 1부터 10000000..까지인가 아무튼 나온다! 

처음엔 alpha[idx] = order;를 해줘서, 중복되는 알파벳들이 계산이 하나도 안됐다. 디버깅 해보니 바로 이해할 수 있었지만.. 코테에서는 디버깅이 잘 되지 않으니 이런 부분은 조금 더 손으로 체크해볼 필요가 있다고 생각했다.

Arrays.sort()는 int형을 내림차순으로 바꾸려면 조금 복잡해지는 것 같아 그냥 뒤에서부터 반복문을 실행했다. 어차피 0이 나오기 시작하면 모두 빈값이므로 for문도 멈출 수 있기때문에 별 상관 없다.

