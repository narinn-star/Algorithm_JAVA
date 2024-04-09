# [2109] 순회강연

## 분류
> 자료 구조
>
> 그리디 알고리즘
> 
> 정렬
> 
> 우선순위 큐

## 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2109 {
    static class Lecture {
        int pay;
        int deadline;

        Lecture(int pay, int deadline) {
            this.pay = pay;
            this.deadline = deadline;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] check = new int[10001];
        Lecture[] lectures = new Lecture[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(pay, deadline);
        }

        Arrays.sort(lectures, (lec1, lec2) -> 
                lec1.pay == lec2.pay ? lec2.deadline - lec1.deadline : lec2.pay - lec1.pay);

        for(int i = 0; i < n; i++){
            for(int j = lectures[i].deadline; j >= 1; j--){
                if(check[j] == 0){
                    check[j] = lectures[i].pay;
                    break;
                }
            }
        }

        int sum = 0;

        for(int p : check){
            if(p != 0) sum += p;
        }

        System.out.println(sum);
    }
}

```

## 문제풀이

아무리 생각해도 우선순위 큐로는 복잡해서 못 풀겠어서, 어제 초기에 생각한 방법으로 하기로 했다.

결과먼저 말하자면, 이게 훨씬 이해도 잘되고 맞는 방법인 것 같음..

일단 고려해야하는 것은 
1. 정렬을 어떻게 할 것인가?
2. 정렬된 강연료/기한으로 어떻게 최대수익을 남길 것인가?
인데, 정렬을 어떻게 하느냐에 따라 여러 방법이 있을 것 같다.

어제 문제 (13904 과제)는 기한을 기준으로 내림차순을 해 날짜별로 비교하는 것을 택하다 실패.. 했는데
오늘은 기한은 오름차순, 강연료는 내림차순으로 정렬을 했다.

그럼 예제를 sort하면 아래와 같이 정렬된다.
100 2
50 10
20 1
10 3
8 2
5 20
2 1

먼저 [0]의 마감기한이 2이고, check[2]에는 아직 할당된 값이 없기 때문에 100을 넣는다. 이후에 마감기한이 2인 강연이 있어도 강연료를 내림차순으로 정렬했기 때문에 비교할 필요도 없이 100이 더 클 것임을 알 수 있다. 
그리고 [1]의 마감기한이 10이고, check[10]에도 아직 할당된 값이 없기 때문에 50을 넣는다. 이 또한 마감기한이 10인 강연이 있어도 50이 무조건 더 크다.
이를 끝까지 반복하면 check에 0이 아닌 수만 더해주면 최대 강연료를 구할 수 있다.

시간을 조금 줄이고 싶으면 마감 기한 최댓값을 담을 변수를 하나 만들어두고, 최대 마감기한 까지만 반복을 돌면서 check[i]값을 더해주면 되지 않을까..?


