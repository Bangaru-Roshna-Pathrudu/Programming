/*
Bob Khan is working with various number systems.
He has created two kinds of addressing systems to share information 
between any two electronic devices.

Addresses in Type-I has following properties:
	- This addressing has four parts, each part is called as 'octet'
	- each octet can have a decimal value between 0 to 255 only
	- each part is separated by periods(.) 
	- Leading 0's are not allowed.
	- each part should conatins atmost 3 digits.

if any octet in the 4 parts, is not satisfying the rules
specified said to be  "invalid" addressing.


Addresses in Type-II has following properties:
	- This addressing has eight parts, each part is called as 'hextet'
	- each hextext can have a hexadecimal value between 0 to ffff only
	- each part is separated by colons (:) 
	- each part should conatins atmost 4 alphanumerics, 
	  as per hexademial number system.

if any hextet in the 8 parts, is not satisfying the rules
specified said to be "Invalid" addressing.
		
You will be given an address as a string	addr.
Your task is to find, whether the given address "addr" belongs to which asddress type.
And return "Type-I" if belongs to "Type-I" Addressing, 
return "Type-II" if belongs to "Type-II" Addressing, 
return "Invalid" if not belongs to either "Type-I"  or "Type-II"Addressing.


Input Format:
-------------
A string, an address addr.

Output Format:
--------------
Print a string output, as mentioned in above statement.


Sample Input-1:
---------------
213.234.45.12

Sample Output-1:
----------------
Type-I


Sample Input-2:
---------------
abcd:ef12:3456:7:dce8:fab9:1:0cda

Sample Output-2:
----------------
Type-II


Sample Input-3:
---------------
abcd:ef12:3456:7:0dce8:fab9:1:0cda

Sample Output-3:
----------------
Invalid


Sample Input-4:
---------------
123.234.34@.31

Sample Output-4:
----------------
Invalid

*/

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String addr = s.nextLine();
        System.out.println(addressType(addr));
    }
    
    static String addressType(String addr){
        if(addr.indexOf(".")!=-1 && isAddressI(addr)){
            return "Type-I";
        }
        else if(addr.indexOf(":")!=-1 && isAddressII(addr)){
            return "Type-II";
        }
        else{
            return "Invalid";
        }
    }
    
    static boolean isAddressI(String addr){
        int i=0,n=addr.length(),c=0;
        while(i<n){
            int j=i;
            if(addr.charAt(j)=='0') return false;
            while(i<n && Character.isDigit(addr.charAt(i))){
                i++;
            }
            if(i<n && addr.charAt(i)!='.') return false;
            if(i<n && addr.charAt(i)=='.') c++;
            if(i-j >3) return false;
            int temp = Integer.parseInt(addr.substring(j,i));
            if(temp<0 || temp>255) return false;
            i++;
        }
        if(c != 3) return false;
        return true;
    }
    
    static boolean isAddressII(String addr){
        int i=0,n=addr.length(),c=0;
        while(i<n){
            int j=i;
            while(i<n && (Character.isDigit(addr.charAt(i)) || isHex(addr.charAt(i)))) i++;
            if(i<n && addr.charAt(i)!=':') return false;
            if(i<n && addr.charAt(i)==':') c++;
            if(i-j > 4) return false;
            i++;
        }
        if(c != 7) return false;
        return true;
    }
    
    static boolean isHex(char ch){
        if(ch=='a' || ch=='b' || ch=='c' || ch=='d' || ch=='e' || ch=='f' || ch=='A' || ch=='B' || ch=='C' || ch=='D' || ch=='E' || ch=='F') return true;
        return false;
    }
}
