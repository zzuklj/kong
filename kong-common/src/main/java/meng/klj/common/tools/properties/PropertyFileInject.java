package meng.klj.common.tools.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
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
}
