/*
There are several bricks with numbers printed on them, ranging from -100 to 100.
They were all lined up in a row. Your task is to calculate the sum of 
the differences between the greatest and smallest values in each contiguous 
group of bricks in the line.

Input Format:
-------------
Single line space separated integers, the values from -100 to 100.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3 8 3 4

Sample Output-1:
----------------
26

Explanation:
------------
The contiguous groups of bricks are as follows:
[3],[8],[3],[4], diff = greatest - smallest is 0.
[3,8], diff = 8 - 3 = 5
[8,3], diff = 8 - 3 = 5
[3,4], diff = 4 - 3 = 1
[3,8,3], diff = 8 - 3 = 5
[8,3,4], diff = 8 - 3 = 5
[3,8,3,4], diff = 8 - 3 = 5
So the sum of all diffs is 5+5+1+5+5+5 = 26.


Sample Input-2:
---------------
-2 0 -2 4 -2

Sample Output-2:
----------------
48

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] dum = s.nextLine().split(" ");
        int[] num = new int[dum.length];
        for(int i=0;i<num.length;i++) num[i] = Integer.parseInt(dum[i]);
        System.out.println(sumOfMaxMinDifference(num));
    }
    
    static int sumOfMaxMinDifference(int[] num){
        if(num.length == 0) return 0;
        int wsize = 2,result = 0;
        while(wsize<=num.length){
            Queue<Integer> queue = new LinkedList<>();
            int sum = 0;
            for(int i=0;i<wsize;i++){
                queue.add(num[i]);
            }
            sum += Collections.max(queue) - Collections.min(queue);
            for(int i=wsize;i<num.length;i++){
                queue.poll();
                queue.add(num[i]);
                sum += Collections.max(queue) - Collections.min(queue);
            }
            result += sum;
            wsize++;
        }
        return result;
    }
}
