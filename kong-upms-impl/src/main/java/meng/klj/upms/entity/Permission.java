package meng.klj.upms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import meng.klj.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_permission")
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "permission_id", type = IdType.AUTO)
    private Integer permissionId;

    /**
     * 所属系统
     */
    private Integer systemId;

    /**
     * 所属上级
     */
    private Integer pid;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型(1:目录,2:菜单,3:按钮)
     */
    private Integer type;

    /**
     * 权限值
     */
    private String permissionValue;

    /**
     * 路径
     */
    private String uri;

    /**
     * 图标
     */
    private String icon;

    /**
     * 状态(0:禁止,1:正常)
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Long ctime;

    /**
     * 排序
     */
    private Long orders;


}
