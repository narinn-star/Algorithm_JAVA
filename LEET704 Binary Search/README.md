# [Leetcode 704] Binary Search

## 분류
> Array
> 
> Binary Search

## 코드
```java
class Solution {
    public int search(int[] nums, int target) { 
        int low = 0;
        int high = nums.length - 1;
        

        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }
}
```

## 문제풀이

이분탐색의 가장 기본적인 문제다. 이분탐색의 전제 조건은 "오름차순 정렬"인데, 이미 정렬된 배열을 주기 때문에 바로 탐색을하면 된다.

반씩 쪼개어 왼쪽 오른쪽을 탐색해가는 방법이다. 만약 mid값이 찾는 값이면 반환하고, 마지막까지 mid와 찾는 값이 같지 않다면 없다는 것이므로 -1을 반환한다. 

[1, 2, 3, 4, 5]에서 1을 찾으려고 한다면 mid값은 2 -> 1 -> 0 순서로 바뀌며 탐색을 하게 된다.
만약 0을 찾으려고 한다면 mid 값은 2 -> 1 -> 0 순서이지만 마지막에 low는 0, high는 -1이 되면서 while문을 탈출하게 된다. 즉, -1이 반환되는 것이다.

for문으로 처음에 작성했는데, 탈출 조건이 이와 같지 않아서인지 틀렸다고 나왔었다. '이분탐색' 풀이법이 오름차순 정렬과 `low <= high`라는 것만 알면 충분히 while문으로 작성할 수 있다.
