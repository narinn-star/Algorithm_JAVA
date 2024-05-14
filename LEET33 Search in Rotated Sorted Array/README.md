# [Leetcode 33] Search in Rotated Sorted Array

## 분류
> Array
> 
> Binary Search

## 코드
```java
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]) high = mid;
                else low = mid + 1;
            }
            else {
                if(target <= nums[high] && target > nums[mid]) low = mid;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
```

## 문제풀이

이분탐색인데 문제가 뭔가 이상했다.. 분명 이분탐색은 오름차순이 되어있어야 하는데, 문제에서는 계속 Rotate를 시켜 숫자가 증가하다가 뚝 떨어져서 다시 증가하는 것이다.😅 

접근법을 몰라서 다른 코드를 참고해보니, 어차피 증가하다가 다시 0부터 증가하는 것이기 때문에, 반으로 나눠서 이분탐색을 하면 되는 거였다.

말이 반으로 나눈다인데, 정확히 반을 나누는 게 아니라 mid값을 이용해서 low와 high 값을 알맞게 바꿔주면서 이분탐색을 진행해야 한다. 
nums[low]가 nums[mid]보다 작거나 같으면 그 다음엔 타겟과 비교해야한다. 타겟이 nums[low]와 nums[mid] 사이에 있으면 high 값을 mid로 내려주고, 반대는 low를 mid + 1로 올려준다.
반대로 nums[high]가 nums[mid]보다 크면 위와 반대로 high값을 비교해 low, high를 적절히 바꿔주면서 이분탐색을 진행한다. 
그러다보면 target과 맞아떨어져서 리턴되는 것.. 만약 리턴 없이 반복문이 끝나면 target이 nums에 없다는 것이기 때문에 -1을 리턴한다.

아주 신기했던 이분탐색 문제..

