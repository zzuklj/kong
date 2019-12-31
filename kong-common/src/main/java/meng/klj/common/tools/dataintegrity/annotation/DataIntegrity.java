package meng.klj.common.tools.dataintegrity.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.TYPE)
@Retention(RUNTIME)
public @interface DataIntegrity {

    /**
     * 表名字
     * @return
     */
    String tableName() default "";

    @Target(FIELD)
    @Retention(RUNTIME)
    @interface NullCheck {

        /**
         * 验空策略
         * @return
         */
        int checkPolicy() default 1;

        /**
         * 字段名
         * @return
         */
        String value() default "";
    }
}
