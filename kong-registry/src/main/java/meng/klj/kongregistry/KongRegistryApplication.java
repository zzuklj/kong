package meng.klj.kongregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class KongRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(KongRegistryApplication.class, args);
    }

}
