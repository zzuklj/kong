package meng.klj.common.base;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
public abstract class BaseController {

    private static final String startLogerTemplate = "{}-begin-operateBy-{}>>>param: {}";
    private static final String endLogerTemplate = "{}-end<<<return: result={}";
git
    private static Cache<Class, Logger> loggerCache = CacheBuilder.newBuilder().build();
}
