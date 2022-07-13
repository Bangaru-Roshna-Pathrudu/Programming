/*
Aruna as a type writer, typing a document in her laptop. Suddently her system got
hacked and whatever she types as words are displaying in reverse and with simple 
braces. She types only lowercase letters.

Inorder to get the actual words, Aruna has to reverse each word starting with the
word which is in innermost most braces and remove those braces.
Help Aruna to get actual words.

Constraints:
------------
  - 0 <= word.length <= 2000
  - Word only contains lower case English characters and parentheses.
    It's guaranteed that all braces are balanced.


Input Format:
-------------
Line-1: a string represents an encoded word.

Output Format:
--------------
return the original string.


Sample Input-1:
---------------
(pqrs)

Sample Output-1:
----------------
srqp


Sample Input-2:
---------------
(uoy(are)woh)

Sample Output-2:
----------------
howareyou

Explanation
------------
Initially "are" will be revesed as "era".
Then (uoyerawoh) will be reversed.

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(getActualInput(input));
    }
    
    static String getActualInput(String s){
        StringBuilder sb = new StringBuilder(s);
        while(sb.indexOf("(") != -1){
            int inds = sb.lastIndexOf("(");
            int inde = inds;
            while(sb.charAt(inde) != ')') inde++;
            StringBuilder sb1 = new StringBuilder(sb.substring(inds+1,inde));
            sb1.reverse();
            sb.replace(inds,inde+1,sb1.toString());
        }
        return sb.toString();
    }
}
