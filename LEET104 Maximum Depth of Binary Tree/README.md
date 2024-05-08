# [Leetcode 104] Maximum Depth of Binary Tree

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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        return searchMaxDepth(root);
    }

    private static int searchMaxDepth(TreeNode root){
        if(root.left == null && root.right == null) return 1;
        
        int leftCnt = 0, rightCnt = 0;
        if(root.left != null){
            leftCnt = searchMaxDepth(root.left) + 1;
        }
        if(root.right != null){
            rightCnt = searchMaxDepth(root.right) + 1;
        }

        return Math.max(leftCnt, rightCnt);
    }
}
```

## 문제풀이

트리의 Depth를 구하는 문제다.

첫번째 Example을 참고해 손으로 풀어보면 아래와 같다.
3.left = 9 (cnt = 2)
9.left = null, 9.right = null (cnt = 2)

3.right = 20 (cnt = 2)
20.left = 15 (cnt = 3)
15.left = null, 15.right = null (cnt = 3)
20.right = 7 (cnt = 3)
7.left = null, 7.right = null (cnt = 3)

답은 3이고, 위의 로직대로 풀이를 한다면 left, right의 각 depth중 cnt가 큰 것을 고르면 된다.

먼저 함수를 호출하기 전 root가 null일 경우를 고려해 return 0 을 작성해주었다.
그리고나서 searchMaxDepth 함수를 호출하면 root의 left,right 값이 null인지 확인하고, Null이라면 루트노드만 존재하기 때문에 1을 반환하고, 그렇지 않다면 위의 로직을 진행한다.
왼쪽 오른쪽 노드의 깊이를 따로 계산해주기 위해 leftCnt, rightCnt를 따로 선언했고 null이 아닌 경우에만 재귀호출을 하도록 했다. 반환값에 +1을 해줌으로써 깊이 계산을 해주었다.


