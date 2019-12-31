package meng.klj.common.tools.dataintegrity;

import lombok.Data;
import meng.klj.common.tools.dataintegrity.annotation.DataIntegrity;

import java.time.LocalDateTime;

@DataIntegrity(tableName = "fact_test_entity")
@Data
public class TestEntity {

    private String id;

    @DataIntegrity.NullCheck
    private String name;

    @DataIntegrity.NullCheck(value = "mobile", checkPolicy = 2)
    private String mobileNumber;

    private LocalDateTime modifyAt;
}


