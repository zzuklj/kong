package meng.klj.upms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import meng.klj.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_user_role")
public class UserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "user_role_id", type = IdType.AUTO)
    private Integer userRoleId;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 角色编号
     */
    private Integer roleId;


}
