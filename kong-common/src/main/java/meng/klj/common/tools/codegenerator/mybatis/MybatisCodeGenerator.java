package meng.klj.common.tools.codegenerator.mybatis;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.google.common.base.Strings;
import lombok.Data;
import lombok.val;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

public class MybatisCodeGenerator {

    @Data
    public static class CustomDataSourceConfig extends DataSourceConfig {

        private String springConfigProfile;

        private ClassLoader classLoader;

        public void setConfigBySpringConfigProfile(){
            if(Strings.isNullOrEmpty(springConfigProfile)){
                return;
            }
            String configFileName = "application-"+springConfigProfile+".yml";
            YamlMapFactoryBean ymlConfigBean = new YamlMapFactoryBean();
            ymlConfigBean.setResources(new ClassPathResource(configFileName, classLoader));
            Map<String, Object> config = ymlConfigBean.getObject();
            Map<String, Object> datasource = (Map<String, Object>) ((Map<String, Object>) config.get("spring")).get("datasource");
            this.setUrl(datasource.get("url").toString())
                .setDriverName(datasource.get("driver-class-name").toString())
                .setUsername(datasource.get("username").toString())
                .setPassword(datasource.get("password").toString());
        }
    }

    public static AutoGenerator buildAutoGenerator(ClassLoader cl, String config){
        return null;
    }
}
