package meng.klj.upms.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import meng.klj.common.BaseVo;

import java.util.List;

@Data
public class UserVo extends BaseVo {

    @ApiModelProperty("t")
    private List<Long> types;

    @ApiModelProperty("i")
    private Integer id;
}
