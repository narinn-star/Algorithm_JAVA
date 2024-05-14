# [Leetcode 994] Rotting Oranges

## 분류
> Array
> 
> Breadth-First Search
>
> Matrix

## 코드
```java
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0}; // 상 하 좌 우
        int[] dy = {0, 1, 0, -1}; // 상 하 좌 우

        int minuite = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++){
                int tmpX = x + dx[i];
                int tmpY = y + dy[i];
                
                if(tmpX >= 0 && tmpY >= 0 && tmpX < grid.length && tmpY < grid[0].length){
                    if(grid[tmpX][tmpY] == 1){
                        queue.add(new int[]{tmpX, tmpY});
                        grid[tmpX][tmpY] = grid[x][y] + 1;
                    }
                }
            }
            
        }


        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return -1;
                else{
                    if(minuite < grid[i][j]) minuite = grid[i][j];
                }
            }
        }

        if(minuite == 0) return 0;
        else return minuite - 2;
    }
}
```

## 문제풀이

백준에 토마토와 거의 동일한 문제! BFS로 푸는 문제라 어렵지 않게 풀었다. 

오렌지 자리 자체에 시간을 쌓아주면 바로 원하는 값을 얻을 수 있다. 한가지 놓쳤던 점은 오렌지가 하나도 들어있지 않은 경우이다. 그럼 애초에 minuite이 0일 테니 마지막 리턴에서 minuite이 0일때와 그렇지 않을 때를 나누어 두었다. 
