/*
Mr Subodh is given an array arr[] of M integers between 0 to 10000.
And he is also given another integer P.
Subodh has to update each integer in the arr[]:
Subodh is allowed to update the arr[i], as follows:
	- arr[i] = arr[i] + P (or) arr[i] = arr[i] - P.

Subodh has to find the update score as the difference between 
maximum element in the arr[] to the minimum element arr[] after all the
elements in the arr[] updated. and return the update score.


Input Format:
-------------
Line-1: Two space separated integers M and P.
Line-2: M space separated integers, integer > 0.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 2
2 6 3

Sample Output-1:
----------------
1

Explanation: 
------------
Update the array as [4, 4, 5]. The score is maximum(arr) - minimum(arr)
=> 5 - 4 = 1.


Sample Input-2:
---------------
4 3
1 11 8 4

Sample Output-2:
----------------
4

Explanation: 
------------
Update the array as [4, 8, 5, 7]. The score is maximum(arr) - minimum(arr) 
=> 8 - 4 = 4


*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int p = s.nextInt();
        int num[] = new int[n];
        for(int i=0;i<n;i++) num[i] = s.nextInt();
        System.out.println(getMinimumRange(num,n,p));
    }
    
    static int getMinimumRange(int[] num,int n,int p){
        Arrays.sort(num);
        int l = num[0]+p;
        int h = num[n-1]-p;
        int result = num[n-1]-num[0];
        for(int i=0;i<n-1;i++){
            int max = Math.max(h,num[i]+p);
            int min = Math.min(l,num[i+1]-p);
            result = Math.min(result,max-min);
        }
        return result;
    }
}
