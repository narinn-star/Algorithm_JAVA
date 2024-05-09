# [Leetcode 98] Validate Binary Search Tree

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
    public boolean isValidBST(TreeNode root) {

        return searchBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean searchBST(TreeNode root, long min, long max){
        if(root == null) return true;
        
        if(root.val <= min || root.val >= max) return false;
        
        return searchBST(root.left, min, root.val) && searchBST(root.right, root.val, max);
    } 
}
```

## 문제풀이

BST가 맞는지 확인하는 문제다.

기본적으로 부모노드보다 좌측 자식 노드는 작아야하고, 우측 자식 노드는 커야한다. 게다가 그 이전에 각 노드들이 좌측/우측 위치가 정해지려면 루트노드의 값과 비교해주어야 한다. 

Example 2를 보면, [5,1,4,null,null,3,6]이 있는데, 3은 부모노드인 4보다 작지만 루트노드인 5보다 작기때문에 애초에 1의 우측 자식노드가 되어야하는 것이 맞다. 

즉, 부모 노드도 계속 가지고 있으면서 자신의 부모 노드와 비교해 알맞은 자리를 찾아가야한다. 이를 위해서 부모노드, 자식 노드 그리고 루트노드까지 가진 채로 함수를 재귀호출했다. 

searchBST(root.left, min, root.val) 호출 시, 
노드가 null이라면 탐색을 종료하고, 노드값이 최솟값 이하거나 노드값이 최대값(루트 노드값) 이상이라면 잘못된 트리이므로 false를 반환한다.

searchBST(root.right, root.val, max) 호출 시,
노드가 null이라면 똑같이 탐색을 종료하고, 노드값이 최솟값(루트 노드값) 이하거나 노드값이 최대값 이상이라면 잘못된 트리이므로 false를 반환한다.

