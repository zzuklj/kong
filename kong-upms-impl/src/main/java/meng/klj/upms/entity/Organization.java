package meng.klj.upms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import meng.klj.common.base.BaseEntity;

/**
 * <p>
 * 组织
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_organization")
public class Organization extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "organization_id", type = IdType.AUTO)
    private Integer organizationId;

    /**
     * 所属上级
     */
    private Integer pid;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 组织描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Long ctime;


}
