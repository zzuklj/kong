package meng.klj.common.tools.dataintegrity;

import meng.klj.common.tools.dataintegrity.annotation.DataIntegrity;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据完整度处理器
 */
public class DataIntegrityHandler {

    public static String handle(Class c){
        if(!c.isAnnotationPresent(DataIntegrity.class)){
            return "";
        }

        //表信息处理
        DataIntegrity di = (DataIntegrity) c.getAnnotation(DataIntegrity.class);
        String tableName = di.tableName();
        if(StringUtils.isEmpty(tableName)){
            tableName = com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline(c.getSimpleName());
        }

        //字段信息处理
        Field[] fields = c.getDeclaredFields();
        List<Object> sumList = Arrays.stream(fields)
                .filter(f -> f.isAnnotationPresent(DataIntegrity.NullCheck.class))
                .map(f -> {
                    DataIntegrity.NullCheck annotation = f.getAnnotation(DataIntegrity.NullCheck.class);
                    String fieldName = annotation.value();
                    int policy = annotation.checkPolicy();

                    if (StringUtils.isEmpty(fieldName)) {
                        String originFieldName = f.getName();
                        fieldName = com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToUnderline(originFieldName);
                    }

                    String calculateFormate = DataIntegrityConstants.CheckNullType.getByCode(policy).getMsg();
                    return String.format(calculateFormate, fieldName);
                }).collect(Collectors.toList());

        int calFieldCount = sumList.size();

        String completedSql = "IF(" + StringUtils.join(sumList, "+") + " = " + calFieldCount + ", 1, 0) complete_flag";

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ")
                .append(completedSql).append(" ")
                .append("FROM ")
                .append(tableName);

        return sb.toString();
    }

}
