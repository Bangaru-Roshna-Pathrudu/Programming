/*
In an online magazine, every day they will ask their readers a puzzle.
The puzzle has to be solved using the following rule set:
	- The puzzle is an 9*9 matrix, and consist of 9 -> 3*3 sub-matrices.
	- Each row in the puzzle should be filled with 1-9digits with out repetition
	- Each column in the puzzle should be filled with 1-9digits with out repetition.
	- Each 3*3 sub-matrix should be filled with 1-9 digits with out repetition.

You will be given the puzzle in the form of 9 strings, each string length is 9.
Your task is check whether the puzzle can be solved or not.
If it is possible to solve, print "true". Otherwise print "false".


Input Format:
-------------
9 Lines: Each line consists of a string  length-9, consist of digits[1-9] and '.' only

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
53..7....
6..195...
.98....6.
8...6...3
4..8.3..2
7...2...6
.6....28.
...419..5
....8..79

Sample Output-1:
----------------
true


Sample Input-2:
---------------
83..7....
6..195...
.98....1.
8...6...3
4..8.3..1
7...2...6
.6....28.
...419..5
....8..79

Sample Output-2:
----------------
false

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] gridrows = new String[9];
        for(int i=0;i<9;i++) gridrows[i] = s.nextLine();
        System.out.println(isSolvable(gridrows));
    }
    
    static boolean isSolvable(String[] gridrows){
        Set<String> clashResolver = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(gridrows[i].charAt(j) != '.'){
                    char ch = gridrows[i].charAt(j);
                    if(!clashResolver.add("row-"+i+"-"+ch) || !clashResolver.add("col-"+j+"-"+ch) || !clashResolver.add("mini-"+(i/3)+"-"+(j/3)+"-"+ch)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
