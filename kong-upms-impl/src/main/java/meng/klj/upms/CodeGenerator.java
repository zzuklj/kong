package meng.klj.upms;

import meng.klj.common.tools.codegenerator.mybatis.MybatisCodeGenerator;

public class CodeGenerator {
    public static void main(String[] args) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        MybatisCodeGenerator.buildAutoGenerator(cl, "code-generator.properties").execute();
    }
}
