package meng.klj.upms;

import meng.klj.upms.test.IUserTestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan({"meng.klj.upms.test"})
@EnableAspectJAutoProxy
public class KongConfigApplication {

    public static void main(String[] args) {
       /* AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(KongConfigApplication.class);
        IUserTestService userTestService = ac.getBean(IUserTestService.class);
        userTestService.getById(1L);*/
    }
}
