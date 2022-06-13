/*
Mr Govind is working with words in english.
He found something interesting between the words.
The properties of those words are as follows:
	- The words have same set of letters and occurences of each letter is also same.
	- For example, read and dear are the two words having same letters,
	and each letter appeared for same number of times in each word.
	- Only the positions of the letters may vary in the words.

You will be given the list of words, Your task is to find and
group the words which have the properties mentioned above.
And print them as list of list of words as shown in the samples. 

Input Format:
-------------
Line-1: A single line space space-separated words, list[].

Output Format:
--------------
Print the list of list of strings.


Sample Input-1:
---------------
tear tera dare dear read rate tare earn near rena

Sample Output-1:
----------------
[[tear, tera, rate, tare], [dare, dear, read], [earn, near, rena]]


Sample Input-2:
---------------
rate tar eat tare tear tea rat

Sample Output-2:
----------------
[[rate, tare, tear], [tar, rat], [eat, tea]]

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] words = s.nextLine().split(" ");
        List<List<String>> answer = new ArrayList<>();
        answer = groupSimilarWords(words);
        System.out.print("[");
        for(List<String> list : answer){
            System.out.print(list);
        }
        System.out.println("]");
    }
    
    static List<List<String>> groupSimilarWords(String[] words){
        Map<String,List<String>> hm = new LinkedHashMap<>();
        for(int i=0;i<words.length;i++){
            String prop = Arrays.toString(getProperty(words[i]));
            if(!hm.containsKey(prop)) hm.put(prop,new ArrayList<>());
            hm.get(prop).add(words[i]);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> val : hm.values()){
            result.add(val);
        }
        return result;
    }
    
    static int[] getProperty(String word){
        int[] prop = new int[26];
        for(int i=0;i<word.length();i++){
            prop[word.charAt(i)-'a']++;
        }
        return prop;
    }
}
