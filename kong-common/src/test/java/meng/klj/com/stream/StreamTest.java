package meng.klj.com.stream;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    static List<User> users ;

    static {
        users.add(User.builder().id(1).name("u1").age(11).score(60).build());
        users.add(User.builder().id(2).name("u2").age(12).score(70).build());
        users.add(User.builder().id(3).name("u3").age(11).score(80).build());
        users.add(User.builder().id(4).name("u4").age(14).score(60).build());
        users.add(User.builder().id(5).name("u5").age(15).score(90).build());
    }

    public static void main(String[] args) {
        users.stream().collect(Collectors.groupingBy(User::getAge));
    }



    @Data
    @Builder
    class User {

        private Integer id;

        private String name;

        private Integer age;

        private Integer score;
    }
}
