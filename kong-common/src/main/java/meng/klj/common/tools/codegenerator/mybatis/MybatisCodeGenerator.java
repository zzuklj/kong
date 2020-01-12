package meng.klj.common.tools.codegenerator.mybatis;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.google.common.base.Strings;
import lombok.Data;
import meng.klj.common.tools.properties.PropertyFileInject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

import static org.apache.commons.lang3.SystemUtils.USER_DIR;

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

    @Data
    public static class CustomGlobalConfig extends GlobalConfig{
        private String projectDir;
        @Override
        public String getOutputDir() {
            if(StringUtils.isNotEmpty(projectDir)){
                return Paths.get(USER_DIR, projectDir, "src/main/java").toString();
            }
            return super.getOutputDir();
        }
    }

    @Data
    public static class CustomStrategyConfig extends StrategyConfig{
        private String includes;

        private String tablePrefixes;

        @Override
        public String[] getInclude() {
            if(StringUtils.isNotEmpty(includes)){
                return includes.split(",");
            }
            return super.getInclude();
        }

        @Override
        public String[] getTablePrefix() {
            if(StringUtils.isNotEmpty(tablePrefixes)){
                return tablePrefixes.split(",");
            }
            return super.getTablePrefix();
        }
    }

    @Data
    public static class CustomFileOutConfig extends FileOutConfig{

        private String outputDir;

        private PackageConfig packageConfig;

        private CustomGlobalConfig customGlobalConfig;

        public CustomFileOutConfig(){
            this.setTemplatePath("mybatis/templates/mapper.xml.ftl");
        }
        @Override
        public String outputFile(TableInfo tableInfo) {
            return Paths.get(USER_DIR,
                    customGlobalConfig.projectDir,
                    outputDir,
                    StringUtils.isNotEmpty(packageConfig.getModuleName()) ? packageConfig.getModuleName() : "" ,
                    tableInfo.getEntityName()+"Mapper.xml").toString();
        }
    }

    public static AutoGenerator buildAutoGenerator(ClassLoader cl, String config){
        PropertyFileInject fileInjector = new PropertyFileInject(cl, config);
        CustomGlobalConfig globalConfig = fileInjector.inject(CustomGlobalConfig.class, "global");
        CustomDataSourceConfig datasource = fileInjector.inject(CustomDataSourceConfig.class, "datasource");
        datasource.setClassLoader(cl);
        datasource.setConfigBySpringConfigProfile();

        PackageConfig packageCinfig = fileInjector.inject(PackageConfig.class, "package");
        TemplateConfig templateConfig = fileInjector.inject(TemplateConfig.class, "template");
        templateConfig.setXml(null);

        CustomStrategyConfig strategyConfig = fileInjector.inject(CustomStrategyConfig.class, "strategy");
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);

        CustomFileOutConfig fileOutConfig = fileInjector.inject(CustomFileOutConfig.class, "xml");
        fileOutConfig.setCustomGlobalConfig(globalConfig);
        fileOutConfig.setPackageConfig(packageCinfig);

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {}
        };
        cfg.setFileOutConfigList(Arrays.asList(fileOutConfig));

        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator
                .setGlobalConfig(globalConfig)
                .setCfg(cfg)
                .setDataSource(datasource)
                .setPackageInfo(packageCinfig)
                .setTemplate(templateConfig)
                .setStrategy(strategyConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine());
        return autoGenerator;
    }
}
