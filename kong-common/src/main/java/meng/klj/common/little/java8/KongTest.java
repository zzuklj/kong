package meng.klj.common.little.java8;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class KongTest {

   static Map<Integer, Integer> cache = new HashMap();
   static Map<String, AtomicInteger> strCountMap = new HashMap();

    @Test
    public void localCache(){
        String s = "sdfashkjiowefsdfs";
        for (char c : s.toCharArray()) {
            countCharNum(String.valueOf(c));
        }
        System.out.println(strCountMap);
    }

    static int fibonacci(int i){
        if( i == 0 || i == 1){
            return i;
        }
        return cache.computeIfAbsent(i, (key) -> fibonacci(i-2) + fibonacci(i-1));
    }

    static void countCharNum(String c){
        strCountMap.computeIfAbsent(c, (key) -> new AtomicInteger()).incrementAndGet();
    }
}
