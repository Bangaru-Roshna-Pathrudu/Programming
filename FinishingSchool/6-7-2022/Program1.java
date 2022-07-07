/*
You are given a set of releases of a software and you are asked to find the most
recent release. There may be multiple checkins of the software in a given branch. 
Each branch may also have sub branches. For example release 3-5-4 refers to the 
fourth checkin in the fifth sub branch of the third main branch. 
This hierarchy can go upto any number of levels. 

If a level is missing it is considered as level 0 in that hierarchy. 
For example 3-5-7 is  same as 3-5-7-0 or even same as 3-5-7-0-0. 
The higher numbers denote more recent releases. 

For example 3-5-7-1 is more recent than 3-5-7 but less recent than 3-6.

Input Format:
-------------
A single line space separated strings, list of releases 

Output Format:
--------------
Print the latest release of the software.


Sample Input-1:
---------------
1-2 1-2-3-0-0 1-2-3

Sample Output-1:
----------------
1-2-3

Sample Input-2:
---------------
3-5-4 3-5-7 3-5-7-1 3-5-7-0-0 3-6

Sample Output-2:
----------------
3-6
*/

/*
import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] ver = s.nextLine().split(" ");
        System.out.println(getLatestVersion(ver));
    }
    
    static String getLatestVersion(String[] ver){
        int len = ver.length;
        String v1 = ver[0];
        for(int k=1;k<len;k++){
            String v2 = ver[k];
            int i=0,j=0,l1=v1.length(),l2=v2.length();
            while(i<l1 && j<l2 && v1.charAt(i) >= v2.charAt(j)){
                i++;
                j++;
            }
            if(i<l1 && j<l2){
                v1 = (v1.charAt(i) > v2.charAt(j))? v1 : v2;
                continue;
            }
            if(i==l1 && j<l2){
                if(v2.charAt(j+1) > '0') v1 = v2;
                continue;
            }
            if(i<l1 && j==l2){
                if(v1.charAt(i+1) == '0') v1 = v2;
            }
        }
        return v1;
    }
}
*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String[] ver = s.nextLine().split(" ");
        System.out.println(getLatestVersion(ver));
    }
    
    static String getLatestVersion(String[] ver){
        String latest = ver[0];
        for(int i=1;i<ver.length;i++){
            if(isLatest(latest,ver[i])) latest = ver[i];
        }
        return latest;
    }
    
    static boolean isLatest(String a,String b){
        String[] v1 = a.split("-");
        String[] v2 = b.split("-");
        int ml = Math.min(v1.length,v2.length),i=0;
        for(i=0;i<ml;i++){
            int vi = Integer.parseInt(v1[i]);
            int vj = Integer.parseInt(v2[i]);
            if(vi < vj) return true;
            if(vi > vj) return false;
        }
        if(v1.length == v2.length) return false;
        if(v1.length > v2.length){
            for(int j=i;j<v1.length;j++){
                if(!v1[i].equals("0")) return false;
            }
            return true;
        }
        else{
            for(int j=i;j<v2.length;j++){
                if(!v2[j].equals("0")) return true;
            }
            return false;
        }
    }
}
