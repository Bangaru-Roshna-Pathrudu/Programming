/*
Mr. Dhanush has provided the string NUM, which solely contains digits.
He is looking for substrings that are numbers and have an equal number of 
distinct digits in each of them. It follows the rule if the number is 123123, 
but not if the number is 12312.

Your task is to assist Mr. Dhanush in determining the number of distinct 
substrings (numbers) of NUM that adhere to the mentioned rule.


Input Format:
-------------
A string NUM, consist of diits [0-9]

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
6767

Sample Output-1:
----------------
5

Explanation: 
------------
The list of words are: 6,7,67,76,6767


Sample Input-2:
---------------
2345432

Sample Output-2:
----------------
16

Explnation:
-----------
The list of words are: 2,3,4,5,23,34,45,54,43,32,234,345,543,432,2345,5432


*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getSubstringCount(str));
    }
    
    static int getSubstringCount(String str){
        int count = 0,l = str.length();
        List<String> subs = new ArrayList<>();
        for(int wsize=1;wsize<=l;wsize++){
            count += helper(str,wsize,subs);
        }
        return count;
    }
    
    static int helper(String str,int size,List<String> subs){
        int count = 0,l = str.length(),i=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(i=0;i<size;i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        String sub = "";
        for(i=size;i<l;i++){
            sub = str.substring(i-size,i);
            if(hasEqualFreq(map) && !subs.contains(sub)){
                count++;
                subs.add(sub);
            }
            char a = str.charAt(i);
            char r = str.charAt(i-size);
            map.put(r,map.get(r)-1);
            if(map.get(r) == 0) map.remove(r);
            map.put(a,map.getOrDefault(a,0)+1);
        }
        sub = str.substring(i-size,i);
        if(hasEqualFreq(map) && !subs.contains(sub)){
            count++;
            subs.add(sub);
        }
        return count;
    }
    
    static boolean hasEqualFreq(Map<Character,Integer> map){
        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == 1;
    }
}
