package meng.klj.upms.entity;

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
public class Kuaidi100Delivery extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String deliveryName;

    private String deliveryCode;

    private String deliverySort;


}
