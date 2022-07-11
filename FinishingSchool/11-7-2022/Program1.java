/*
Sukumar is a mathematics teacher.
Sukumar is always intersted to create logical problems.
He has given a problem to the students to solve it.
Students are given sentence with set of words, students has to find two words
W1 and W2, such that there should be no common letters between W1 and W2, 
and return the product of W1.length and W2.length.
If there are no such words in the sentence return 0.

Your task is to solve the problem given by Sukumar and help the students.

Input Format:
-------------
Space separated strings, the sentence with set of words[].

Output Format:
--------------
Print an integer, maximum product of two max length words.


Sample Input-1:
---------------
there is an wondeful event going to happen in the school

Sample Output-1:
----------------
30

Explanation: 
------------
The two words will be "there", "school".
or "going", "happen"..etc


Sample Input-2:
---------------
elegant jewels are made here

Sample Output-2:
----------------
0

Explanation: 
------------
All words have atleast one letter in common.

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] words = s.nextLine().split(" ");
        System.out.println(getProduct(words));
    }
    
    static int getProduct(String[] words){
        int[] bitrep = new int[words.length];
        int product = 0;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                bitrep[i] = bitrep[i] | (1 << (words[i].charAt(j) - 'a'));
            }
        }
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((bitrep[i] & bitrep[j]) == 0){
                    product = Math.max(product,words[i].length() * words[j].length());
                }
            }
        }
        return product;
    }
}
