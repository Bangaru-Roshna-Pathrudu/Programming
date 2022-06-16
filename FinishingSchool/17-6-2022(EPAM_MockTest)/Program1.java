/*
In a room there are 8 boxes in a row and each box is either locked or unlocked.
In each step, status of the boxes, modifies according to the following rules:
	- if the adjacent boxes of the box[i] (i.e., box[i-1] and box[i+1] ) are 
	  either both locked or both unlocked, then the box[i] becomes locked.
	- Otherwise box[i] is unlocked.
	- The first and the last boxes in the row can't have two adjacent boxes.

You are given the initial status of 8-boxes status[] array and an integer S, 
consist of either 0 or 1. where 1 indiactes locked status, 
0 indiactes unlocked status, and S is the number of steps.

Your task is to find and return the final status of the boxes after S steps,
either locked or unlocked.


Input Format:
-------------
Line-1: Eight space separated integers, initial status of the 8-boxes, 0 or 1 only
Line-2: An integer S, numebr of steps.

Output Format:
--------------
Print the list of integers, final status of the 8-boxes.

Sample Input-1:
---------------
1 1 0 0 1 0 0 1
6

Sample Output-1:
----------------
[0, 1, 0, 1, 1, 1, 1, 0]

Explanation:
------------
Initial status is Step-0:
Step-0: [1, 1, 0, 0, 1, 0, 0, 1]
Step-1: [0, 0, 0, 0, 1, 0, 0, 0]
Step-2: [0, 1, 1, 0, 1, 0, 1, 0]
Step-3: [0, 0, 0, 1, 1, 1, 1, 0]
Step-4: [0, 1, 0, 0, 1, 1, 0, 0]
Step-5: [0, 1, 0, 0, 0, 0, 0, 0]
Step-6: [0, 1, 0, 1, 1, 1, 1, 0]
Final status is Step-6.


Sample Input-2:
---------------
1 0 0 1 0 1 1 0
8

Sample Output-2:
----------------
[0, 0, 0, 1, 1, 0, 0, 0]

*/

import java.util.*;

class Solution {
    public int[] boxesAfterSsteps(int[] cells, int N) {
        //implement your code here
        /*
        for(int j=0;j<N;j++){
            int pre = cells[0];
            for(int i=1;i<cells.length-1;i++){
                int in = cells[i];
                cells[i] = pre ^ cells[i+1];
                cells[i] = (cells[i]==1)?0:1;
                pre = in;
            }
            cells[0] = 0;
            cells[cells.length-1] = 0;
        }
        */
        int n = N % cells.length;
        while(n-->0){
            int[] dum = new int[8];
            dum[0] = 0;
            dum[7] = 0;
            for(int i=1;i<7;i++){
                if(cells[i-1] == cells[i+1]){
                    dum[i] = 1;
                }
                else dum[i] = 0;
            }
            cells = dum;
        }
        return cells;
    }
}
