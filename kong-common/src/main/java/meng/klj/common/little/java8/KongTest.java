package meng.klj.common.little.java8;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import meng.klj.common.tools.dataintegrity.TestEntity;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@Slf4j
public class KongTest {

   static Map<Integer, Integer> cache = new HashMap();
   static Map<String, AtomicInteger> strCountMap = new HashMap();

   private static List<TestEntity> testEntities;

    static{
        try {
            File f = new ClassPathResource("test.json").getFile();
            String s = FileUtils.readFileToString(f);
            testEntities = JSON.parseArray(s, TestEntity.class);

            /*ObjectMapper mapper = new ObjectMapper();
            JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, TestEntity.class);
            testEntities = mapper.readValue(s, javaType);*/
        }catch (Exception e){
            log.info("file read error");
        }
    }

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
    public void streamGo() {
        int sum = testEntities.stream()
                .filter(e -> Objects.nonNull(e.getScores()))
                .flatMap(e -> e.getScores().stream())
                .mapToInt(Integer::new)
                .sum();
    }


}
