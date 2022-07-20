/*
Mr Madhav is playing a game, He played the game for N terms, the scores are 
given as list of integers as scores[], contains both +ve and -ve integers.

The game rules are as follows (i.e., game has negative points also ) :
 - Each term, the player has to start with 0 points.
 - The player has to play N terms and record the points earned or lost.
 - After N terms played, he wants to maxmize the gain or minimize the loss.
 - The amount is calculated as follows, for every 'i' in 0<=i<N :
    * step-1: Add all the points from index-'0' to index-'i+1' points
    * step-2: Add all the points from index-'i' to index-'N-1' points
    * Keep the maximum amount from the above two steps.

Your task is to return the maximum amount Mr Madhav gained or The minimum amount 
Mr Madhav lost.

Input Format:
-------------
Line-1: Comma separated integers, list[] of numbers.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
5,-9,-6,7,7,4

Sample Output-1:
----------------
18

Explanation: 
------------
When i=0: 5, 8 
When i=1: -4, 3
When i=2: -10, 12
When i=3: -3,18 
When i=4: 4, 11
When i=5: 8, 4  =>  So, Max is 18.


Sample Input-2:
---------------
-5,-4,-6,-7

Sample Output-2:
----------------
-5

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] st = s.nextLine().split(",");
        int[] num = new int[st.length];
        for(int i=0;i<st.length;i++) num[i] = Integer.parseInt(st[i]);
        System.out.println(getMaximum(num));
    }
    
    static int getMaximum(int[] num){
        int l = num.length,max = Integer.MIN_VALUE,sum = 0;
        for(int i=0;i<l;i++){
            sum += num[i];
            max = Math.max(max,sum);
        }
        sum = 0;
        for(int i=l-1;i>=0;i--){
            sum += num[i];
            max = Math.max(max,sum);
        }
        return max;
    }
}
