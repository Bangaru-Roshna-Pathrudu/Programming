/*
Mr Lokesham is given a set of N numbers nums[].
He can find the highest sum in the given set easily.
He got and idea to append the set nums[] with itself for M-1 times.
And then find the highest sum of the contiguous subset of nums[].
The subset length can be 0, in such case the answer is 0.

For example, nums[]=[1,2,3], and m=3 means the final set nums[]=[1,2,3,1,2,3,1,2,3].

And after you get the final set nums[], Lokesham wants to find 
the highest sum possible from the final set nums[].

Your task is to help the Lokesham, to find the highest possible sum.
The sum might be very long, return "sum modulo 10^9 + 7".

Constraints:
-----------
1 <= nums[].length <= 50000
1 <= m <= 50000
-9999<= nums[i] <= 9999


Input Format:
-------------
Line-1: Two space separated integers
Line-2: N space separated integers, nums.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 4
5 -4 2

Sample Output-1:
----------------
14

Explanation:
------------
Append the set [4-1] more times
Resultant Set is : 5 -4 2 5 -4 2 5 -4 2 5 -4 2
Sum of the contiuous subset [5 -4 2 5 -4 2 5 -4 2 5] is 14.


Sample Input-2:
---------------
3 2
1 2 3

Sample Output-2:
----------------
12


Sample Input-3:
---------------
3 5
3 -2 -1

Sample Output-3:
----------------
3

*/

import java.util.*;
import java.io.*;

class Solution {
    public long mAppendedMaxSum(int[] nums, int m) {
        //implement your code here
        long currsum = nums[0],maxsum = nums[0],mod = 1000000007,sum = 0;
        for(int i=0;i<nums.length;i++) sum += nums[i];
        sum %= mod;
        for(int i=1;i<nums.length*2;i++){
            currsum = Math.max(nums[i%nums.length],currsum + nums[i%nums.length]);
            maxsum = Math.max(currsum,maxsum);
        }
        return (maxsum <= 0)?(maxsum):((((sum)*(m-2)) + maxsum)%mod);
    }
}

/*
import java.util.*;
import java.io.*;

class Solution {
    public int mAppendedMaxSum(int[] nums, int m) {
        //implement your code here
        long sum = 0,mod = 1000000007;
        for(int i=0;i<nums.length;i++) sum += nums[i];
        sum %= mod;
        if(m == 1){
            return (int)(kadanes(nums)%mod);
        }
        else if(sum < 0){
            return (int)(kadanesOfTwoCopies(nums)%mod);
        }
        else{
            return (int)(((int)((m-2)*sum)%mod) + (int)(kadanesOfTwoCopies(nums)%mod));
        }
    }
    
    static int kadanes(int[] nums){
        int curr = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(curr >= 0){
                curr += nums[i];
            }
            else{
                curr = nums[i];
            }
            if(curr > max){
                max = curr;
            }
        }
        return max;
    }
    
    static int kadanesOfTwoCopies(int[] nums){
        int[] tnums = new int[nums.length*2];
        for(int i=0;i<nums.length;i++) tnums[i] = nums[i];
        for(int i=0;i<nums.length;i++) tnums[i+nums.length] = nums[i];
        return kadanes(tnums);
    }
}
*/
