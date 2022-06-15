/*
A professional thief entered into a floor in a building,
The floor has M*N inter connected rooms, the thief can enter into any room 
from any other room. And there are few rooms closed from inside, so the thief 
cannot enter into them. Initially the thief is at room[0][0] and has to exit 
from room[m-1][n-1].

You will be given the array room[][], filled with either 0 or 1.
Here, 1-indiactes a closed room, 0-indiactes a open room.
Your task is to find and print the number of unique escape routes 
from room[0][0] and room[m-1][n-1]. And the thief can move only in 
two directions one is forward direction and other is downward direction.


Input Format:
-------------
Line-1: Two space separated integers, M and N.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 4
0 0 0 0
0 1 0 0
0 0 1 0

Sample Output-1:
----------------
2


Sample Input-2:
---------------
4 4
0 0 0 0
0 0 1 0
1 0 0 0
0 0 1 0

Sample Output-2:
----------------
3

*/

import java.util.*;

class Solution{
    
    static Map<String,Integer> map = new HashMap<>();
    
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
        System.out.println(pathCount(grid,m,n));
    }
    
    static int pathCount(int[][] grid,int m,int n){
        return dfs(0,0,grid,m,n);
    }
    
    static int dfs(int i,int j,int[][] grid,int m,int n){
        if(i>=m || j>=n || grid[i][j]==1) return 0;
        if(i==m-1 && j==n-1 && grid[i][j]==0){
            return 1;
        }
        String key = i+"-"+j;
        if(map.containsKey(key)) return map.get(key);
        map.put(key,dfs(i,j+1,grid,m,n)+dfs(i+1,j,grid,m,n));
        return map.get(key);
    }
}
