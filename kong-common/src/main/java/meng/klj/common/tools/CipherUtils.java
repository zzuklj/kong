package meng.klj.common.tools;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import static java.util.Locale.CHINA;

public class CipherUtils {

    public static void main(String[] args) throws Exception {
        //KeyPairGenerator.getInstance("");
        Faker faker = new Faker(CHINA);
        Name name = faker.name();
        String s = name.fullName();
        System.out.println(faker.name().fullName());
        UUID uuid = UUID.randomUUID();
        uuid.toString();
    }

}
