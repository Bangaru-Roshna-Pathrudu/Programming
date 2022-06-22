/*
Mr Rajendra Tapadia is given a number N as string to Mr Satyam, and ask him 
to find the number of ways to make that number N equal to zero by using 
the following steps:
    - He need to perform either '+' or '-' operation between two adjacent digits
    - You can repeat the above step to make the N value to 0.
    
For example: if N is 454522 then it's possible to perform the '+'/'-' operations 
the following way, 4+5-4-5-2+2, 4-5-4+5-2+2, 4+5-4-5+2-2 or 4-5-4+5+2-2.
A total of 4 ways.

Your task is to help Mr Satyam to find the number of ways possible to make N to 0
using the above steps. Print "invalid", if it is not possible.

Input Format:
-------------
A String, the number N.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
13741

Sample Output-1:
----------------
2

Explanation: 
------------
The ways are, 1+3-7+4-1 and 1-3+7-4-1.


Sample Input-2:
---------------
2351

Sample Output-2:
----------------
invalid

*/

import java.util.*;

class Solution{
    
    static int count=0;
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String num = s.nextLine();
        System.out.println(getTotalCombinations(num));
    }
    
    static String getTotalCombinations(String num){
        int sum = Integer.parseInt(num.substring(0,1));
        helper(num,1,sum);
        return (count==0)?"invalid":count+"";
    }
    
    static void helper(String num,int ind,int sum){
        if(ind == num.length()){
            if(sum == 0) count++;
            return;
        }
        int n = Integer.parseInt(num.substring(ind,ind+1));
        helper(num,ind+1,sum+n);
        helper(num,ind+1,sum-n);
    }
}
