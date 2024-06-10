# [Programmers 단속카메라] 

## 분류
> 탐욕법(Greedy)

## 코드
```java
import java.util.Arrays;

public class Pro단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int max = routes[0][1];

        for(int i = 1; i < routes.length; i++){
            if(routes[i][1] >= max && routes[i][0] <= max){
                continue;

            } else {
                max = routes[i][1];
                answer++;
            }
        }

        return answer + 1;
    }
}
```

## 문제풀이

처음엔 o1[0] - o2[0]으로, 진입 지점을 기준으로 오름차순 정렬을 했다. [i][1]과 [i+1][0]을 비교해서 [i+1][1]을 갱신해주거나, continue하도록 했는데 아마도 이건 예제에 너무 맞춰서 풀어서인지.. 풀고 나니 내가 생각해도 예외가 너무 많은 듯해서 다 지워버렸다 😭

하나씩 예외를 찾아가다 보니, o1[1] - o2[1]으로 나간 지점을 기준으로 오름차순 정렬을 했다. 그렇게 해야 다음 구간과 비교했을 때, 현재 최대값을 저장해둔 max에 카메라를 설치할지 하지 않을지 정할 수 있기 때문이다. max값 보다 진입 지점이 작거나 같고, 나간 지점이 크거나 같을 때는 continue를, 그 외의 경우에는 max값도 갱신해주면서 카메라를 설치하면 된다. 이렇게 하면 마지막 카메라를 설치하는 경우가 빠져있기 때문에 answer에 1을 더한 값을 리턴했다.

level 3이라 조금 겁내면서 시작했는데, 꽤나 쉽게(?) 풀렸다. 😚
