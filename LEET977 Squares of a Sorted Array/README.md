# [Leetcode 977] Squares of a Sorted Array

## 분류
> Array
> 
> Two Pointers
>
> Sorting

## 코드
```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int idx1 = 0, idx2 = nums.length - 1;
        int i = nums.length - 1;

        while(idx1 <= idx2){
            if(Math.abs(nums[idx1]) > Math.abs(nums[idx2])){
                res[i] = nums[idx1] * nums[idx1];
                idx1++;
            }else {
                res[i] = nums[idx2] * nums[idx2];
                idx2--;
            }
            i--;
        }

        return res;
        // for(int i = 0; i < nums.length; i++){
        //     nums[i] = nums[i] * nums[i];
        // }

        // Arrays.sort(nums);

        // return nums;
    }
}
```

## 문제풀이

1. 정렬은 Arrays.sort()로 해주는 게 바로 떠올라서, 하나씩 돌면서 제곱해준 뒤 sorting해주었다.
2. 토픽에 투 포인터가 있어서 투포인터로 다시 풀어보았다. 처음과 맨 끝에 포인터를 두고, 절대값이 더 큰 값이 제곱했을 때 더 클 것이기 때문에 큰 값을 선택해서 res[i]에 넣어주었다. 절대값이 같을 때는 당연히 else문으로 들어갈 것이기 때문에 고려해줄 필요 없고, while 조건문만 `idx1 <= idx2`로 해주면 모든 수를 확인할 수 있다. 
작은 값을 선택해서 res[0]부터 넣게 되면, 가운데 0이 있을 수도 있어서 처음에 non-decreasing으로 주어진다는 전제가 깔려있기 때문에 큰 수부터 확인해주는 게 맞다.
