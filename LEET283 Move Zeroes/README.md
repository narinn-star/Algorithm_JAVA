# [Leetcode 283] Move Zeroes

## 분류
> Array
> 
> Two Pointers

## 코드
```java
class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == 0){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }
}
```

## 문제풀이

기본에 충실하자..
반복문 횟수 잘 보고 돌려야 끝까지 돌지 않겠어요?

이중 반복문 작성하는데 두 번째 반복문 범위를 nums.length - 1로 해두어서 자꾸 1 3 0 0 12가 나왔다. 분명히 다 바꿨는데 말이징

더 꼼꼼하게 체크해야겠조?
