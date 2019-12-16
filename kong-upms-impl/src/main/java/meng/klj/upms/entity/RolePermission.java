package meng.klj.upms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import meng.klj.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色权限关联表
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_role_permission")
public class RolePermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "role_permission_id", type = IdType.AUTO)
    private Integer rolePermissionId;

    /**
     * 角色编号
     */
    private Integer roleId;

    /**
     * 权限编号
     */
    private Integer permissionId;


}
