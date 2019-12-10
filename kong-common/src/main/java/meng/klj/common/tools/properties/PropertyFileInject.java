package meng.klj.common.tools.properties;

import java.util.Properties;

public class PropertyFileInject {

    private Properties properties;

    private PropertyNameMapper propertyNameMapper;

    public PropertyFileInject(ClassLoader cl, String... properttFiles){
        properties = new Properties();
        propertyNameMapper = PropertyNameMapper.UnderLine2Camel;
    }
}
