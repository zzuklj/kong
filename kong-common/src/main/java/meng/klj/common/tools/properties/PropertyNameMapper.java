package meng.klj.common.tools.properties;

import static java.lang.Character.toUpperCase;

public interface PropertyNameMapper {

    default String key2ClassPropertyName(String keyName){
        return keyName;
    }

    PropertyNameMapper UnderLine2Camel = new PropertyNameMapper() {
        @Override
        public String key2ClassPropertyName(String keyName) {
            StringBuilder sb = new StringBuilder();
            char[] chars = keyName.toCharArray();
            for(int i = 0; i < chars.length; i++){
                if('_' == chars[i] ){
                    sb.append(toUpperCase(chars[++i]));
                }else{
                    sb.append(chars[i]);
                }
            }
            return sb.toString();
        }
    };
}
