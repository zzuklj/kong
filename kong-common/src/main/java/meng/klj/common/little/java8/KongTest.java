package meng.klj.common.little.java8;

import com.fasterxml.jackson.databind.ObjectMapper;
import meng.klj.common.tools.dataintegrity.TestEntity;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
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

    @Test
    public void streamGo() throws IOException {
        File f = new ClassPathResource("test.json").getFile();
        String s = FileUtils.readFileToString(f);
        ObjectMapper mapper = new ObjectMapper();
        TestEntity testEntity = mapper.readValue(s, TestEntity.class);
        String id = testEntity.getId();

    }
}
