# [Leetcode 200] Nuber of Islands

## 분류
> Array
> 
> Depth-First Search
> 
> Breadth-First Search
> 
> Union Find
> 
> Matrix

## 코드
```java
class Solution {
    private static int[] dx;
    private static int[] dy;
    private static Queue<int[]> queue;
    private static int m, n;

    public int numIslands(char[][] grid) {
        int cnt = 0;
        m = grid.length;
        n = grid[0].length;
        dx = new int[]{-1, 0, 1, 0}; // 상 우 하 좌
        dy = new int[]{0, 1, 0, -1}; // 상 우 하 좌
        queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1') {
                    cnt++;
                    findIslands(i, j, grid);
                }
            }
        }
        return cnt;
    }
    
    private static void findIslands(int x, int y, char[][] grid){
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()){
            int qX = queue.peek()[0];
            int qY = queue.peek()[1];
            queue.poll();

            if(qX < 0 || qX >= m || qY < 0 || qY >= n || grid[qX][qY] != '1') continue;
            
            grid[qX][qY] = '0';            

            for(int i = 0; i < 4; i++){
                int tmpX = qX + dx[i];
                int tmpY = qY + dy[i];
                
                if(tmpX >= 0 && tmpY >= 0 && tmpX < m && tmpY < n && grid[tmpX][tmpY] == '1'){
                    queue.offer(new int[]{tmpX, tmpY});
                }
            }
        }
    }
}
```

## 문제풀이

섬의 개수를 구하는 문제다. 백준에서도 섬의 개수라는 문제로 거의 동일한 문제가 있었기도 했고, BFS/DFS 문제는 수도 없이 풀었던지라 정말 자신 있는 문제였다.

큐를 사용하는 BFS를 선택했고, 아마 DFS보다 시간은 느릴 것이다. 아무래도 재귀가 좀 더 빠르고 Queue 내장 클래스를 사용하면 시간이 더 늘어나는 것은 당연하니.. 아무튼 
`if(qX < 0 || qX >= m || qY < 0 || qY >= n || grid[qX][qY] != '1') continue;`
이 부분만 빼면 완벽했다.. timeout이 나서 add, offer 차이점도 찾아보고 visited 배열도 다시 넣어보고 했는데 결국 미리 네방향을 탐색하지 않도록 제한해주는 것이 가장 효율적인 방법이었다. 
백준에서 문제를 풀 때는 한 번도 타임아웃이 난 적이 없어서 내가 완벽하다고 생각했던 것이 문제였다😰
