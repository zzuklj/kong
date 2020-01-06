package meng.klj.common.tools.dataintegrity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import meng.klj.common.tools.dataintegrity.annotation.DataIntegrity;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@DataIntegrity(tableName = "fact_test_entity")
@Data
public class TestEntity {

    private String id;

    @DataIntegrity.NullCheck
    private String name;

    @DataIntegrity.NullCheck(value = "mobile", checkPolicy = 2)
    private String mobileNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyAt;

    private List<Integer> scores;
}


