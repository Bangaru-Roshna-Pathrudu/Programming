import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String binstr = s.next();
        System.out.println(operationCount(binstr));
    }
    
    static int operationCount(String binstr){
        int count = 0,carry = 0,i=binstr.length()-1;
        while(i>0){
            int lsb = binstr.charAt(i)-'0';
            if(carry + lsb == 1){
                count += 2;
                carry = 1;
            }
            else{
                count++;
            }
            i--;
        }
        return count+carry;
    }
}
