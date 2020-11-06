package meng.klj.upms.schedule;

import org.springframework.stereotype.Component;

@Component
public class SendEmail implements AbstractScheduleJob {
    @Override
    public String execute(String param) {
        System.out.println("send email ================");
        return null;
    }
}
