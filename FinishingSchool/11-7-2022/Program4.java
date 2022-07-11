/*
Mr.Miryam is very hungry he went to a new restaurant Avakaya Biryani. 
The restaurant was designed in such a way that 
the tables are arranged in a P*Q arrangement.

The PXQ arrangement is a character grid, contains 4 types of characters, 
each character indicated as follows.

'*' is Miryam location, there is exactly one '*'.
'#' is a Miryam's table with food. There may be multiple options.
'O' is an empty space, where we can walk through the way.
'X' is an hurdle unit, we cannot walk through these units.

The minimal path is decided such way Miryam can walk to any adjacent cell 
vertically or horizontally.

Your task is to help Mr.Miryam to find the smallest path to reach the food table.
If no path to reach table return -1.

Input Format:
-------------
Line-1: Two integers P and Q, Size of the grid.
Next P lines: Q space separated characters, from this set -> [ *, #, O, X ] 

Output Format:
--------------
Print and integer, Length of the shortest path.


Sample Input-1:
---------------
4 6
X X X X X X
X * O O O X
X O O # O X
X X X X X X

Sample Output-1:
----------------
3


Sample Input-2:
---------------
5 8
X X X X X X X X
X * O X O # O X
X O O X O O X X
X O O O O # O X
X X X X X X X X

Sample Output-2:
----------------
6

*/

import java.util.*;

class Solution{
    
    static int[] dirs = {1,0,-1,0,1};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] grid = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(tableDistance(grid,m,n));
    }
    
    static int tableDistance(char[][] grid,int m,int n){
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '*'){
                    q.offer(new int[]{i,j});
                    break;
                }
            }
        }
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int k=0;k<size;k++){
                int curr[] = q.poll();
                for(int i=0;i<4;i++){
                    int x = curr[0] + dirs[i];
                    int y = curr[1] + dirs[i+1];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y] != 'X'){
                        if(grid[x][y] == '#') return dist;
                        grid[x][y] = 'X';
                        q.offer(new int[]{x,y});
                    }
                }
            }
        }
        return -1;
    }
}
