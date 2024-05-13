# [Leetcode 278] First Bad Version

## 분류
> Binary Search
> 
> Interactive


## 코드
```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int min = 1, max = n;
        int res = 0;
        while(min <= max){
            int mid = min + (max - min) / 2;
            boolean check =isBadVersion(mid);
            if(check){
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return res;
    }
}
```

## 문제풀이

가장 먼저 bad version이 되었던 것을 찾는 문제다. 문제에서 이미 bad version을 판별하는 api는 제공해주었기 때문에 이를 이용해서 bad version 번호를 찾기만 하면 된다.

Example 1의 Explanation과 Contraints를 보고 이분탐색을 선택했다.

예를 들어, 1 2 3 4 5가 있는데 4가 bad라면, 가장 먼저 (1 + 5) / 2 = 3으로, 3은 bad가 아니기 때문에 false를 반환한다. 그렇다면 1, 2, 3 모두 bad version이 아니기 때문에 시작 범위를 올려줘야한다. 즉, min 값을 3 + 1로, 4 ~ 5를 탐색한다. 
그 다음 mid 값은 (4 + 5) / 2 = 4로  4는 bad이기 때문에 true를 반환한다. 이때 res에 mid값을 넣어주는 이유는 해당 조건문이 실행된 것은 가장 작은 bad를 찾았기 때문에 갱신해준 것이다.

한 가지 알게된 점은, mid값을 (min + max) / 2로 하면 timeout이 나서 min + (max - min) / 2로 구해준다는 것이다. (max - min)을 해주는 이유는 n의 범위를 초과하지 않기 위해서다. 이 문제에서 n의 최대값은 int 자료형의 최대값과 동일하다. 만약 max값이 최대값일 때 (min + max) / 2로 계산하면 오버플로우가 발생하기 때문에 (max - min)을 사용한다.
제약조건이 없더라도 mid를 계산할 때 이렇게 작성하는 것을 권장한다고 한다.. 🧐
