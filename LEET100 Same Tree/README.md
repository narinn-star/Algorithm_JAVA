# [Leetcode 100] Same Tree

## 분류
> Tree
> 
> Depth-First Search
> 
> Breadth-First Search
> 
> Binary Tree

## 코드
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;

        if(p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
    }
}
```

## 문제풀이

두 트리가 완벽하게 일치하는 지 확인하는 문제다.
이제 릿코드 definition이 조금은 익숙해져서 금방 풀었다.

먼저 해당 정점의 값이 같은지 비교해 주고, 같다면 그 다음 정점(왼쪽 또는 오른쪽 자식 정점)을 비교하기 위해 재귀호출을 해주었다. 만약 정점이 같지 않다면 바로 false를 리턴해준다.

이 정점들이 같은지 비교하기 위해서는 해당 정점의 값들이 null이 아니어야 하는데, 이를 먼저 판별해주지 않으면 비교하는 데서 오류가 발생하기 때문에 먼저 null인지 검사를 해준다. 둘 다 null이라면 같은 것으로, 둘 중 하나만 null이면 같지 않은 것으로 판단해 false를 리턴해주며 null이라면 자식 정점이 없기 때문에 따로 재귀 호출은 하지 않는다.
