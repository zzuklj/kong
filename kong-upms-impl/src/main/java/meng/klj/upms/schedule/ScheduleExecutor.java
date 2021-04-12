package meng.klj.upms.schedule;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 定时任务执行器
 */
//@Component
public class ScheduleExecutor implements ApplicationContextAware {

    // 上下文对象实例
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private Map<String, AbstractScheduleJob> beanMap = Maps.newHashMap();

    @PostConstruct
    public void setScheduleJob(){
        beanMap = applicationContext.getBeansOfType(AbstractScheduleJob.class);
    }

    @Scheduled(cron = "0/10 * * * * ?")
    public void doJob(){
        beanMap.values().forEach(executeJob -> executeJob.execute(null));
    }

}
