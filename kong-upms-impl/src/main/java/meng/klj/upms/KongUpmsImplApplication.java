package meng.klj.upms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"meng.klj"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"meng.klj"})
@MapperScan(value = {"meng.klj.upms.**.mapper"})
@EnableSwagger2
@EnableScheduling
public class KongUpmsImplApplication implements WebMvcConfigurer {

    static {
        System.setProperty("es.set.netty.runtime.available.processors","false");
    }

    private ApiInfoBuilder apiInfo() {
        return new ApiInfoBuilder()
                .title("北平项目-用户中心服务")
                .description("用户中心服务 Swagger2 Api 文档");
    }

    public static void main(String[] args) {
        SpringApplication.run(KongUpmsImplApplication.class, args);
    }



}
