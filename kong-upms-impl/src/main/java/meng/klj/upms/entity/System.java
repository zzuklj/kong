package meng.klj.upms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import meng.klj.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("upms_system")
public class System extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "system_id", type = IdType.AUTO)
    private Integer systemId;

    /**
     * 图标
     */
    private String icon;

    /**
     * 背景
     */
    private String banner;

    /**
     * 主题
     */
    private String theme;

    /**
     * 根目录
     */
    private String basepath;

    /**
     * 状态(-1:黑名单,1:正常)
     */
    private Integer status;

    /**
     * 系统名称
     */
    private String name;

    /**
     * 系统标题
     */
    private String title;

    /**
     * 系统描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Long ctime;

    /**
     * 排序
     */
    private Long orders;


}
