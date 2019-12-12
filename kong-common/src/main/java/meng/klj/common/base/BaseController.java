package meng.klj.common.base;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.Optional.ofNullable;

@Slf4j
public abstract class BaseController {

    private static final String startLoggerTemplate = "{}-begin-operateBy-{}>>>param: {}";

    private static final String endLoggerTemplate = "{}-end<<<return: result={}";

    private static Cache<Class, Logger> loggerCache = CacheBuilder.newBuilder().build();

    private void log(BiConsumer<Logger, String> logAction){
        Callable<Logger> callable = () -> LoggerFactory.getLogger(this.getClass());
        Logger logger = null;
        try {
            logger = loggerCache.get(this.getClass(), callable);
        } catch (ExecutionException e) {
            log.warn("cannot get logger from cache.", e);
        }
        String methodName = Thread.currentThread().getStackTrace()[4].getMethodName();
        ofNullable(logger).ifPresent(l -> logAction.accept(l, methodName));
    }

    public static ThreadLocal<ControllerContext> contextContainer = new ThreadLocal<>();

    @ModelAttribute
    protected void setContextContainer(ControllerContext context){
        contextContainer.set(context);
    }

    protected <U, E> JsonResult<E> toJsonResult(U serviceResult, Function<U, E> converter){
        JsonResult<E> jsonResult = new JsonResult<>();
        jsonResult.setStatus(true);
        jsonResult.setMsg("操作成功！");
        jsonResult.setResult(converter.apply(serviceResult));
        return jsonResult;
    }

    protected <E, VO, U> JsonResult<E> voJsonResultTemplate(
            VO vo,
            Consumer<VO> validator,
            Function<VO, U> processor,
            Function<U, E> converter){

        Long userId = ofNullable(contextContainer.get()).map(ControllerContext::getRequestUserId).orElse(null);
        log((logger, methodName) -> logger.debug(startLoggerTemplate, methodName, userId, vo));
        validator.accept(vo);
        U tempValue = processor.apply(vo);
        log((logger, methodName) -> logger.debug(endLoggerTemplate, methodName, String.valueOf(tempValue)));
        return toJsonResult(tempValue, converter);
    }

    protected <E, VO, U> JsonResult<E> simpleTemplate(
            VO vo,
            Function<VO, U> processer){
        return voJsonResultTemplate(vo, null, processer, null);
    }


}
