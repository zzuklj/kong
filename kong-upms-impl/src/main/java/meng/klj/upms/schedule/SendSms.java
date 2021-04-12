package meng.klj.upms.schedule;

import org.springframework.stereotype.Component;

@Component
public class SendSms implements AbstractScheduleJob {
    @Override
    public String execute(String param) {
        System.out.println("send sms ================");
        return null;
    }
}
