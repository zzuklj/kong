package meng.klj.upms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import meng.klj.common.base.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author klj
 * @since 2020-01-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("userName")
    private String userName;

    private String password;

    @TableField("realName")
    private String realName;

    private String business;

    private String email;

    @TableField("headPicture")
    private String headPicture;

    @TableField("addDate")
    private LocalDate addDate;

    @TableField("updateDate")
    private LocalDate updateDate;

    /**
     * 1：正常
2：冻结
3：删除
     */
    private Integer state;


}
