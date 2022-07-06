/*
Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(generateWords(str));
    }
    
    static List<String> generateWords(String str){
        List<String> result = new ArrayList<>();
        result = helper(str);
        Collections.sort(result);
        return result;
    }
    
    static List<String> helper(String str){
        if(str.length() == 0){
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        if(str.length() == 1){
            List<String> result = new ArrayList<>();
            result.add(str);
            return result;
        }
        List<String> result = new ArrayList<>();
        if(str.charAt(0) == '['){
            int ind = str.indexOf("]");
            String[] left = str.substring(1,ind).split(",");
            List<String> right = helper(str.substring(ind+1));
            for(String ch : left){
                for(String ch1 : right){
                    result.add(ch+ch1);
                }
            }
        }
        else{
            List<String> right = helper(str.substring(1));
            for(String st : right){
                result.add(str.charAt(0)+st);
            }
        }
        return result;
    }
}
