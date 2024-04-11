# [Leetcode 1] Two Sum

## 분류
> Array
> 
> Hash Table

## 코드
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
```

## 문제풀이

브루트포스를 선택해서 풀었다.
해시 테이블을 사용하는 방법이 있는 것 같은데.. 아직 해시 테이블 안써봤음.. medium 가서 해도 되겠지..?
