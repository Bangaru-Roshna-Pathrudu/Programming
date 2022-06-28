/*
Subodh is interested in playing with Strings,
For a given String 'S', Subodh applies some rules to find the value of 'S'.
The rules are as follows:
	- If it is a balanced () has value 1
	- XY has value X + Y , where X and Y are balanced () strings.
	- (Z) has score 2 * Z , where Z is a balanced parentheses string.
	
Find out the value of given String and print it.

Note: All the given strings are balanced

Input Format:
----------------
A String contains only '(', ')'


Output Format:
------------------
Print an integer as result.


Sample Input-1:
-------------------
()

Sample Output-1:
---------------------
1

Sample Input-2:
-------------------
(())

Sample Output-2:
---------------------
2

Sample Input-3:
-------------------
(()(()))

Sample Output-3:
---------------------
6


*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String exp = s.nextLine();
        System.out.println(getValue(exp));
    }
    
    static int getValue(String exp){
        StringBuilder sb = new StringBuilder(exp);
        int ind = sb.lastIndexOf("(");
        while(ind>=0){
            if(ind>=0){
                int lind = sb.substring(ind).indexOf(")"),l = 0;
                lind += ind;
                if(lind == ind + 1){
                    l = 1;
                    sb.replace(ind,lind+1,"1");
                }
                else{
                    String str = String.valueOf(Integer.parseInt(sb.substring(ind+1,lind))*2);
                    l = str.length();
                    sb.replace(ind,lind+1,str);
                }
                if(ind+l<sb.length() && sb.charAt(ind+l)!=')'){
                    int j = ind+l;
                    while(j<sb.length() && sb.charAt(j)!=')') j++;
                    String str = String.valueOf(Integer.parseInt(sb.substring(ind,ind+l)) + Integer.parseInt(sb.substring(ind+l,j)));
                    sb.replace(ind,j,str);
                }
            }
            else break;
            ind = sb.lastIndexOf("(");
        }
        return Integer.parseInt(sb.toString());
    }
}
