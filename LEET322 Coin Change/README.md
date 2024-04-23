# [Leetcode 322] Coin Change

## 분류
> Array
> 
> Dynamic Programming
> 
> Breadth-First Search

## 코드
```java
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, Integer.MAX_VALUE - 1);

        arr[0] = 0;

        Arrays.sort(coins);
        
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j]){
                    arr[i] = Math.min(arr[i], arr[i - coins[j]] + 1);
                }
            }
        }
        if(arr[amount] == Integer.MAX_VALUE - 1) return -1;
        else return arr[amount];
    }
}
```

## 문제풀이

릿코드에서 처음 풀어본 dp문제! amount값을 찾기 위해서 dp로 하나씩 쌓았다.

0을 만드는 데에는 아무것도 더하지 않아도 되기 때문에 0을 넣어두고 시작했다.

arr[1]부터 채우기 시작하는데, coin 배열에 있는 동전을 하나씩 가져가서 최솟값을 만들어준다.
arr[1]은 1을 만들기 위한 동전 갯수를 넣어주는데, 예제 [1,2,5]를 예로 들면 1이 바로 들어가게 되고,
arr[2] = 1, arr[3] = 2, arr[4] = 2, arr[5] = 1, arr[6] = 2, arr[7] = 2, arr[8] = 3, arr[9] = 3, arr[10] = 2, arr[11] = 3이 나오게 된다.

arr[i]와 arr[i - coins[j]] + 1을 비교해주는 것이다. 

마지막에 조건문은 구할 수 없는 경우를 찾기 위함이고, -1을 해준 이유는 배열이 넘쳐서 하나빼두었다. 그래도 오류 안나서 다행...
