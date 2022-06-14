/*
ABC Township purchased a land which has some places are lakes some are normal land.
You will be given a grid as 2d array gridLand[][] of size M*N, 
where 0 indicates land, and 1 indicates water.  

HMDA has to approve the layout of the township, 
So, that the engineers has to decide the number of floors of each building 
by following the guidelines listed below:
	- You are allowed to constrcut the builing in a land cell only.
	- The number of floors of a building in land cell must be non-negative.
	- You are not allowed to construct a building in a lake cell, so floors 
	  count is 0.
	- Any two adjacent buildings must have an absolute floors difference of 
	at most 1. A building is adjacent to another building if one of the sides 
	of one builing is touching with the other either north, east, south, or west.
	
Your task is to find an assignment of floors for each building such that 
the maximum number of floors of the buildings in the gridLand is maximized and 
return the number of floors of a building which has maximum floors.

Input Format:
-------------
Line-1: Two space separated integers, M * N, size of the land.
Next M lines: N space separated integers, either 0 or 1 only.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 3
1 0 0
1 1 0
1 1 1

Sample Output-1:
----------------
2

Explanation:
------------
One of the possibility of layout of the buildings is:
0 1 2
0 0 1
0 0 0
So, the maximum number of floors of a building is 2.


Sample Input-2:
---------------
3 4
1 0 0 0
1 0 0 0
1 1 0 0

Sample Output-2:
----------------
3

Explanation:
------------
One of the possibility of layout of the buildings is:
0 1 2 3
0 1 2 3
0 0 1 2
So, the maximum number of floors of a building is 3.

*/

import java.util.*;

class Solution{
    
    static int[][] dirs = {{0,-1},{-1,0},{0,1},{1,0}};
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = s.nextInt();
            }
        }
        System.out.println(tallestBuildingsHeight(grid,m,n));
    }
    
    static int tallestBuildingsHeight(int[][] grid,int m,int n){
        boolean visited[][] = new boolean[m][n];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    visited[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            max++;
            for(int k=0;k<size;k++){
                int temp[] = q.poll();
                for(int i=0;i<4;i++){
                    int x = temp[0] + dirs[i][0];
                    int y = temp[1] + dirs[i][1];
                    if(x>=0 && y>=0 && x<m && y<n && !visited[x][y]){
                        visited[x][y] = true;
                        q.offer(new int[]{x,y});
                    }
                }
            }
        }
        return max-1;
    }
}

/*
import java.util.*;

class Solution{
    
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = s.nextInt();
            }
        }
        System.out.println(tallestBuildingsHeight(grid,m,n));
    }
    
    static int tallestBuildingsHeight(int[][] grid,int m,int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) grid[i][j] = 0;
                else grid[i][j] = 1;
            }
        }
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    bfs(i,j,grid,visited);
                }
            }
        }
        return max;
    }
    
    static void bfs(int i,int j,int[][] grid,boolean visited[][]){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0;k<size;k++){
                int temp[] = q.poll();
                visited[temp[0]][temp[1]] = true;
                int min = 0;
                if(i-1>=0 && grid[i-1][j] != 0){
                    if(!visited[i-1][j]) q.offer(new int[]{i-1,j});
                    min = Math.min(min,grid[i-1][j]);
                }
                if(j-1>=0 && grid[i][j-1] != 0){
                    if(!visited[i][j-1]) q.offer(new int[]{i,j-1});
                    min = Math.min(min,grid[i][j-1]);
                }
                if(i+1<grid.length && grid[i+1][j] != 0){
                    if(!visited[i+1][j]) q.offer(new int[]{i+1,j});
                    min = Math.min(min,grid[i+1][j]);
                }
                if(j+1<grid[0].length && grid[i][j+1] != 0){
                    if(!visited[i][j+1]) q.offer(new int[]{i,j+1});
                    min = Math.min(min,grid[i][j+1]);
                }
                if(Math.abs(grid[i][j]-min) < 1) grid[i][j]++;
                max = Math.max(grid[i][j],max);
            }
        }
    }
}
*/
