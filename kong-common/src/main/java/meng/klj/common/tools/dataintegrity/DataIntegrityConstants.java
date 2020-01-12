package meng.klj.common.tools.dataintegrity;

import lombok.AllArgsConstructor;
import lombok.Getter;

public interface DataIntegrityConstants {

    @AllArgsConstructor
    @Getter
    enum CheckNullType{
        DEFAULT(1,"IF(ISNULL( %s ), 0, 1)"),
        BOOLEAN(2,"%s");

        private Integer code;
        private String msg;

        public static CheckNullType getByCode(Integer code){
            for(CheckNullType bt : values()){
                if (bt.getCode().equals(code)) {
                    return bt;
                }
            }
            return null;
        }
    }
}
