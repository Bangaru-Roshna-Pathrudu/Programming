/*
Mr Srikanth has given a task to his students.
He has given a list of N numbers, nums[], the list contains both poitive and 
negative integers. Also given two more list of integers as start[] and end[],
where start[] list contains starting indices, and end[] contains ending indices.

Now, the students task is to check and return the boolean values as a list res[],
for each 'i' between, 0<=i<N, check that the rearrangement of sublist of nums[], 
from nums[start[i]] to nums[end[i]] forms an arithmetic series or not.

NOTE: A series is said to be arithmetic, if and only if,
nums[i+1]-nums[i]==nums[1]-nums[0], for all valid 'i' value.

i.e., 1,3,5,7,9 is a valid series.
2, 3, 5, 8, 12 is not a valid series.


Constraints:
------------
0<= start[i]<=end[i] < nums[].length


Input Format:
-------------
Line-1: comma separated integers, nums[]
Line-2: comma separated integers, start[]
Line-3: comma separated integers, end[]

Output Format:
--------------
Print a list of boolean values of length equals to start[]/end[] list.


Sample Input-1:
---------------
2,8,4,6,10,11,12,14,20,16,18,22,24
0,1,3,6,8
3,4,5,9,12

Sample Output-1:
----------------
[true,true,false,false,true]

Explanation: 
------------
The sublist from 0 to 3 is: [2, 8, 4, 6] => [2,4,6,8] is valid
The sublist from 1 to 4 is: [8, 4, 6,10] => [4,6,8,10] is valid
The sublist from 3 to 5 is: [6, 10, 11] is invalid for any arrangement.
The sublist from 6 to 9 is: [12, 14, 20, 16] is invalid
The sublist from 8 to 12 is: [20, 16, 18, 22,24] is valid


Sample Input-2:
---------------
-8,-6,-2,-8,-4,10,15,-20,-15,-10,-5
0,1,6,4,8,7
4,4,9,7,9,10

Sample Output-2:
----------------
[false,true,false,false,true,true]

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] d1 = sc.nextLine().split(",");
        String[] d2 = sc.nextLine().split(",");
        String[] d3 = sc.nextLine().split(",");
        int[] num = new int[d1.length];
        int[] start = new int[d2.length];
        int[] end = new int[d3.length];
        for(int i=0;i<num.length;i++) num[i] = Integer.parseInt(d1[i]);
        for(int i=0;i<start.length;i++) start[i] = Integer.parseInt(d2[i]);
        for(int i=0;i<end.length;i++) end[i] = Integer.parseInt(d3[i]);
        System.out.println(Arrays.toString(isArithmeticSubset(num,start,end)));
    }
    
    static boolean[] isArithmeticSubset(int[] num,int[] start,int[] end){
        int l1 = num.length,l2 = start.length;
        boolean result[] = new boolean[l2];
        int ind = 0;
        for(int i=0;i<l2;i++){
            int st = start[i];
            int en = end[i];
            int[] subarr = new int[en-st+1];
            int in = 0;
            for(int j=st;j<=en;j++) subarr[in++] = num[j];
            Arrays.sort(subarr);
            result[ind++] = checkSeries(subarr,en-st);
        }
        return result;
    }
    
    static boolean checkSeries(int[] arr,int end){
        int diff = Integer.MAX_VALUE;
        for(int j=0;j<end;j++){
            int diffd = arr[j+1]-arr[j];
            if(diff == Integer.MAX_VALUE) diff = diffd;
            if(diff != diffd){
                return false;
            }
        }
        return true;
    }
}
