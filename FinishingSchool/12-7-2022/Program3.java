/*
There are a series of boxes and each box is labelled with a number.
Your task is to find the subsets of boxes such that addition of all 
the numbers written on each box makes an odd number.

Return only the number of such subsets exist.
Since the answer can be very large, return it modulo 10^9 + 7.

Input Format:
-------------
Line-1: an integer n represents the number of boxes
Line-2: n space seperated integers represents the numbers on the boxes.

Output Format:
--------------
return an integer represents number of subsets.

Sample Input-1:
---------------
3
1 5 7

Sample Output-1:
----------------
4

Explanation:
------------
subsets with odd sum are [1],[5],[7],[1,5,7].

Sample Input-2:
---------------
4
2 3 4 5

Sample Output-2:
----------------
6

Explanation:
-------------
subsets with odd sum are [3],[5],[2,3],[3,4],[4,5],[2,3,4].

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i=0;i<n;i++) num[i] = sc.nextInt();
        System.out.println(OddSumSubsetCount(num,n));
    }
    
    static int OddSumSubsetCount(int[] num,int n){
        int even = 0,odd = 0,tot = 0;
        for(int i=0;i<n;i++){
            if(num[i]%2 == 0){
                even++;
            }
            else{
                int t = even;
                even = odd;
                odd = t;
                odd++;
            }
            tot += odd;
        }
        return tot;
    }
}
