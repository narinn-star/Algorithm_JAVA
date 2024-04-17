# [Leetcode 121] Best Time to Buy and Sell Stock

## 분류
> Array
> 
> Dynamic Programming

## 코드
```java
class Solution {
    public int maxProfit(int[] prices) {
        // int max = 0;

        // for(int i = 0; i < prices.length - 1; i++){
        //     for(int j = i + 1; j < prices.length; j++){
        //         if(prices[i] > prices[j]) continue;
        //         max = Math.max(max, prices[j] - prices[i]);
        //     }
        // }
        // return max;

        int price = prices[0];
        int max = 0;

        for(int i = 1; i < prices.length; i++){
            if(price > prices[i]){
                price = prices[i];
            }else {
                max = Math.max(prices[i] - price, max);
            }
        }
        return max;
    }
}
```

## 문제풀이

첫번째 이중for문으로 했을 때, 시간초과로 실패가 떴다.. (easy는 시간초과 생각 안해도 될거라 생각한 오만함..)

시간을 줄이려면 for문을 하나로 줄여야한다고 생각했는데, 또 다르게 비교할 수 있는 방법이 있었다. 손으로 써보다가 발견한것..!
기준값을 내가 바꿔주면 된다. max값을 찾아주는 것은 똑같고, 처음에 price에 값을 담아두고 시작하는게 포인트
