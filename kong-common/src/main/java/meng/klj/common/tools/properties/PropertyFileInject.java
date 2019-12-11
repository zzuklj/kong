package meng.klj.common.tools.properties;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Properties;

@Slf4j
public class PropertyFileInject {

    private Properties properties;

    private PropertyNameMapper propertyNameMapper;

    public PropertyFileInject(ClassLoader cl, String... propertyFiles){
        properties = new Properties();
        propertyNameMapper = PropertyNameMapper.UnderLine2Camel;
        Arrays.stream(propertyFiles).forEach(p -> {
            try {
                properties.load(new InputStreamReader(cl.getResourceAsStream(p), Charset.forName("utf-8")));
            } catch (IOException e) {
                log.warn("cannot read property file: {}", p);
            }
        });
    }

    public <T> T inject(Class<T> propertyClass, String prefix){
        T t = BeanUtils.instantiateClass(propertyClass);
        Enumeration<?> names = properties.propertyNames();
        while(names.hasMoreElements()){
            String keyName = (String) names.nextElement();
            String value = properties.getProperty(keyName);
            if(!Strings.isNullOrEmpty(value)){
                String propertyName = keyName;
                if(propertyName.startsWith(prefix)){
                    propertyName = propertyName.substring(prefix.length());
                    if(propertyName.charAt(0) == '.'){
                        propertyName = propertyName.substring(1);
                    }
                    propertyName = propertyNameMapper.key2ClassPropertyName(propertyName);
                    Method method = ReflectionUtils.findMethod(propertyClass, "set" + StringUtils.capitalize(propertyName));
                    if(Objects.nonNull(method) && method.getParameterTypes().length == 1){
                        method.setAccessible(true);
                        try {
                            method.invoke(t, ConvertUtils.convert(value, method.getParameterTypes()[0]));
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            log.warn("cannot set property {} on field: {}", keyName, method.getName());
                        }
                    }
                }
            }
        }
        return t;
    }
}
