/*
Crazy Mohan is the head master of a school.
He do the things differently. All the students in the school,
formed as a grid for the assembly.

Crazy Mohan asked them to stand in sorted order of thier heights diagonally, 
in order to make the assembly look more unique. The students started arranging 
themselves according to their heights.

You will be given initial order of the assembly, heights of the students.
Now it is your task to find the final state of the assembly of students and print it.

Input Format:
-------------
Line-1: Two space separated integers M and N, Size of the Grid
Next M lines: N space separated integers, heights of the students.

Output Format:
--------------
Print the rid of integers, final state of the assembly.


Sample Input-1:
---------------
3 4
2 8 5 2
10 9 10 9
1 5 8 5

Sample Output-1:
----------------
2 5 5 2
5 8 8 9
1 10 9 10


Sample Input-2:
---------------
4 6
10 9 10 7 5 9
5 4 9 9 10 10
8 8 1 9 5 2
1 2 1 5 9 9

Sample Output-2:
----------------
1 9 5 2 5 9
1 4 9 9 7 10
2 5 5 9 9 10
1 8 8 10 9 10


*/

import java.util.*;

class Solution{
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
        int[][] result = new int[m][n];
        result = rearrangeAssembly(grid,m,n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    static int[][] rearrangeAssembly(int[][] grid,int m,int n){
        List<Integer> line = new ArrayList<>();
        for(int k=m-1;k>=0;k--){
            int i=k,j=0;
            while(i<m && j<n){
                line.add(grid[i++][j++]);
            }
            Collections.sort(line);
            i = k;
            j = 0;
            int c = 0;
            while(i<m && j<n){
                grid[i++][j++] = line.get(c++);
            }
            line.clear();
        }
        for(int k=0;k<n;k++){
            int i=0,j=k;
            while(i<m && j<n){
                line.add(grid[i++][j++]);
            }
            Collections.sort(line);
            i = 0;
            j = k;
            int c = 0;
            while(i<m && j<n){
                grid[i++][j++] = line.get(c++);
            }
            line.clear();
        }
        return grid;
    }
}
