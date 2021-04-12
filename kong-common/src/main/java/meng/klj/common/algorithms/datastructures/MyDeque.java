package meng.klj.common.algorithms.datastructures;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.asn1.eac.UnsignedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MyDeque {

    public static void main(String[] args) {
        String s = toHex(160);
        System.out.println(s);
    }


    public static String toHex(int num){
        if(num==0)
            return "0";
        String hex="0123456789abcdef",ans="";
        while(num!=0&&ans.length()<8){
            ans=hex.charAt(num&0xf)+ans;
            num>>=4;
        }
        return ans;
    }

}
