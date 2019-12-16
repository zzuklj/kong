package meng.klj.upms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import meng.klj.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户权限关联表
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_user_permission")
public class UserPermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "user_permission_id", type = IdType.AUTO)
    private Integer userPermissionId;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 权限编号
     */
    private Integer permissionId;

    /**
     * 权限类型(-1:减权限,1:增权限)
     */
    private Integer type;


}
