/*
Mr Toronto working with operators in programming language.
He is given statement S, which is a valid statement and consist of digits [0-9] 
and characters '?', ':', 'Y', 'N', where Y indiactes true and N indicates false.
And the statement conatins only numbers with single digits.
(>=10 value is not allowed)

The operator '?' works as follows:
	- if S="Y?1:2" - as Y means true, it will return 1.
	- if S="N?1:2" - as N means false, it will return 2.

Your task is to help Mr Toronto to execute the statement S and return the result.
The result must be either a digit [0-9] or "Y" or "N".

Input Format:
-------------
A string S, a valid statement.

Output Format:
--------------
Print a string, the result of the statement S.


Sample Input-1:
---------------
Y?N?3:4:2

Sample Output-1:
----------------
4

Explanation:
------------
Given statement is Y?N?3:4:2 -> Y?(N?3:4):2 
Y means "true", So you have to execute N?3:4
N means "false", So the answer is 4.


Sample Input-2:
---------------
N?Y?N?N:Y:N:Y

Sample Output-2:
----------------
Y

Explanation:
------------
Given statement is N?Y?N?N:Y:N:Y -> N?(Y?(N?N:Y):N):Y
N means "false", So the answer is Y.

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String inpstr = s.next();
        System.out.println(evaluate(inpstr));
    }
    
    static String evaluate(String inpstr){
        StringBuilder sb = new StringBuilder(inpstr);
        int ind = sb.lastIndexOf("?");
        while(ind>=1){
            String segment = sb.toString().substring(ind-1,ind+4);
            sb.delete(ind-1,ind+4);
            if(segment.charAt(0) == 'Y'){
                sb.insert(ind-1,segment.charAt(2));
            }
            else{
                sb.insert(ind-1,segment.charAt(4));
            }
            ind = sb.lastIndexOf("?");
        }
        return sb.toString();
    }
}
