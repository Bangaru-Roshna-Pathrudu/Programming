/*
Vimal and Kamal are pals. They're attempting to play a word game.
The following are the game's rules:
- There will be two terms in the game: w1 and w2.
- One of the words must be chosen by Kamal.
- If Kamal picks w1, w1[i] should be greater than w2[i], for every 'i' 
  in 0 <= i < w1.length OR vice versa, for some shuffle of w1 and w2.
- Kamal is the winner if the preceding step is true; else, Kamal is the loser.

Your task is to assist Kamal in selecting the winning word.
If feasible, print 'winner,' if not, 'loser.'

Input Format:
-------------
Two space separated strings, two words w1 and w2.

Output Format:
--------------
Print a boolean result.


Sample Input-1:
---------------
break class

Sample Output-1:
----------------
winner

Explanation:
------------
Kamal chooses w2="class", and the shuffle of w1 is "beark", 
so that Kamal wins the word game. 


Sample Input-2:
---------------
kmit ngit

Sample Output-2:
----------------
loser

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String w1 = s.next();
        String w2 = s.next();
        String result = (getResult(w1,w2))?("winner"):("loser");
        System.out.println(result);
    }
    
    static boolean getResult(String w1,String w2){
        char[] ch1 = w1.toCharArray(),ch2 = w2.toCharArray();
        int i=0;
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        while(i<w1.length() && ch1[i]>=ch2[i]){
            i++;
        }
        if(i==w1.length()) return true;
        i=0;
        while(i<w1.length() && ch2[i]>=ch1[i]) i++;
        if(i==w2.length()) return true;
        return false;
    }
}
