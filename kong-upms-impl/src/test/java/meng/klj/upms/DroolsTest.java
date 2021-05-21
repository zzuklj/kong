package meng.klj.upms;

import meng.klj.upms.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KongUpmsImplApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DroolsTest {

    @Autowired
    private KieSession kieSession;

    @Test
    public void testUser(){
        User user = new User();
        user.setUserName("klj");
        user.setState(1);

        kieSession.insert(user);
        kieSession.fireAllRules();
    }

}
