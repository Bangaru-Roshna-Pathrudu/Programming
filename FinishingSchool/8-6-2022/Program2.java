/*
Jason Statham is a well known transporter.
He transports goods from one place to other place using his container.
The container is divided into M*N slots, you can place M*N items in it.
In the container few slots are closed, you can't use them.
No other item can move from it.

When the items are loaded the container looks like an M*N grid, 
but to unload the items from the container it is turned 90-derees clockwise.
So, the Items in the container moves through the empty slots and set one on one.
If there is an closed slot, the items will be fall on the closed slot.

You will be given a matrix of size M*N, consists of 3 letters [I,O,S]
Where I indicates item, O indicates closed slot, S indicates empty slot.

Your task is to help Jason Stathamto know the positions of items, empty slots and 
closed slots after turning the container 90-degree clockwise.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the container
Next M lines: A string of length N, consists only 3 characters [I, O, S]

Output Format:
--------------
Print a charcter matrix of size N*M as described in sample.


Sample Input-1:
---------------
2 3
ISI
ISO

Sample Output-1:
----------------
SS
II
OI

Explanation:
------------
Look at hint for explanation.


Sample Input-2:
---------------
3 6
IIOSOS
IIIOSS
IIISIS

Sample Output-2:
----------------
SII
SII
IIO
IOS
ISO
ISS

Explanation:
------------
Look at hint for explanation.

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        s.nextLine();
        String[][] grid = new String[m][n];
        for(int i=0;i<m;i++){
            grid[i] = s.nextLine().split("");
        }
        String[][] altgrid = new String[n][m];
        altgrid = transformedContainer(grid);
        for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--){
                System.out.print(altgrid[i][j]);
            }
            System.out.println();
        }
    }
    
    static String[][] transformedContainer(String[][] grid){
        String[][] result = new String[grid[0].length][grid.length];
        String[][] temp = new String[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            int j=0;
            while(j<grid[0].length){
                int c = 0,k=j;
                while(j<grid[i].length && !grid[i][j].equals("O")){
                    if(grid[i][j].equals("I")) c++;
                    j++;
                }
                int p = j - 1;
                while(p>=k && c>0){
                    grid[i][p] = "I";
                    c--;
                    p--;
                }
                while(p>=k && p>=c){
                    grid[i][p--] = "S";
                }
                j++;
            }
        }
        temp = transpose(grid);
        return temp;
    }
    
    static String[][] transpose(String[][] grid){
        String[][] result = new String[grid[0].length][grid.length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                result[j][i] = grid[i][j];
            }
        }
        return result;
    }
}
