/*
There are n boxes of balls in a row, every i-th box contains balls[i] balls.

A series of boxes is called Arithmetic, if it consists of at least three boxes
and if the difference between the number of balls in any two consecutive boxes is same.

A subset of boxes is called Arithmetic Subset,
if subset[i], subset[i+1], subset[i+2], ..., subset[j] is Arithmetic.

Your task is to findout the number of Arithmetic Subsets in the row of boxes.

Input Format:
-------------
Line-1 : An integer N, number of boxes.
Line-2 : N space separated integers balls[i], i-th box contains balls[i] balls. 

Output Format:
--------------
Print an integer, number of Arithmetic Subsets.


Sample Input:
---------------
4
1 2 3 4

Sample Output:
----------------
3

Explanation:
------------
Arithmetic Subsets are: [1,2,3], [2,3,4], [1,2,3,4].


Sample Input:
---------------
5
1 3 5 7 9

Sample Output:
----------------
6

Explanation:
------------
Arithmetic Subsets are: [1,3,5], [3,5,7], [5,7,9], [1,3,5,7], [3,5,7,9], [1,3,5,7,9].


*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int num[] = new int[n];
        for(int i=0;i<n;i++) num[i] = s.nextInt();
        System.out.println(arithmeticSubsetCount(num,n));
    }
    
    static int arithmeticSubsetCount(int[] num,int n){
        int count = 0,sum = 0;
        if(n < 3) return 0;
        for(int i=1;i<n-1;i++){
            while(i<n-1 && num[i-1] - num[i] == num[i] - num[i+1]){
                count++;
                sum += count;
                i++;
            }
            count = 0;
        }
        return sum;
    }
}
