/*
Mr Robert is working with strings.
He selected two strings S1 and S2, may differ in length,
consists of lowercase alphabets only.

Mr Robert has to update the strings S1, S2 to meet any one of the criteria:
	- All the alphabets in S1 should be less than all the alphabets in S2.
	- All the alphabets in S2 should be less than all the alphabets in S1.
	- Both S1 and S2 should have only one distinct alphabet in it.
To Achieve, one of the criteria, you are allowed to replace any one letter in 
the string with any other lowercase alphabet.

Your task is to help Mr Robert, to find the minimum replacements to be done to 
update the strings S1 and S2 to meet one of the criteria mentioned above.


Input Format:
-------------
Two space separated strings S1 and S2.

Output Format:
--------------
Print an integer, minimum number of replacements.


Sample Input-1:
---------------
apple ball

Sample Output-1:
----------------
3

Explanation:
------------
Consider the best way to make the criteria true:
- Update S2 to "baaa" in 2 replacements, and Update S1 to "cpple" in 1 replacement
then every alphabet in S2 is less than every alphabet in S1.
        (OR)
- Update S1 to "ppppp" in 3 replacements, then every alphabet in S2 is less 
than every alphabet in S1.


Sample Input-2:
---------------
kmit kmec

Sample Output-2:
----------------
2

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String a = s.next();
        String b = s.next();
        System.out.println(getMinimumReplacements(a,b));
    }
    
    static int getMinimumReplacements(String a,String b){
        int freqa[] = new int[26];
        int freqb[] = new int[26];
        for(int i=0;i<a.length();i++){
            freqa[a.charAt(i)-'a']++;
        }
        for(int i=0;i<b.length();i++){
            freqb[b.charAt(i)-'a']++;
        }
        int min = Integer.MAX_VALUE;
        int suma = 0,sumb = 0;
        for(int i=0;i<26;i++){
            suma += freqa[i];
            sumb += freqb[i];
            min = Math.min(min,suma + b.length() - sumb);
            min = Math.min(min,sumb + a.length() - suma);
        }
        int max = 0;
        for(int i=0;i<26;i++){
            max = Math.max(max,freqa[i]+freqb[i]);
        }
        return Math.min(min,a.length()+b.length()-max);
    }
}
