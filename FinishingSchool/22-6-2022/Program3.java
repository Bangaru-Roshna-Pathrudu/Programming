/*
There is a crowd attended for a political meeting with different groups and each
group had unique colored dresses wearing.We asked n people in the crowd that
"How many are attended from your group excluding yourself?" and collected the 
answers in an integer array answers where group[i] is the answer of the ith group.

Given the array groups, return the minimum possible attendance that could be 
there in the meeting.

Constraints:
------------
    1 <= n <= 1000
    0 <= group[i] < 1000

Input Format:
-------------
Line-1: An integer n, represents the people answered.
Line-2: n space seperated integers represents the answers.

Output Format:
--------------
return an integer represents mimimum possible attendance.

Sample Input-1:
---------------
1,2,1,2,1

Sample Output-1:
----------------
7

Explanation:
------------
Out of the three groups that answered "1", there could be two groups wearing to 
the same color, say white and the other group wearing some other color, say 'pink'
The two groups that answered "2" could both be wearing the same color, say 'yellow'.
The minimum possible number of attendance in the meeting is 7.

    
Sample Input-2:
---------------
3,2,1,6,4

Sample Output-2:
----------------
21


*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] nums = s.nextLine().split(",");
        System.out.println(getAttendance(nums));
    }
    
    static int getAttendance(String[] nums){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.offer(Integer.parseInt(nums[i]));
        }
        int count = 0;
        while(!pq.isEmpty()){
            int n = pq.peek(),c=0;
            while(!pq.isEmpty() && pq.peek()==n){
                c++;
                pq.poll();
            }
            if(n == 0){
                count += c;
                continue;
            }
            count += (n+1)*(c/(n+1));
            count += (c%(n+1)==0)?0:n+1;
        }
        return count;
    }
}
