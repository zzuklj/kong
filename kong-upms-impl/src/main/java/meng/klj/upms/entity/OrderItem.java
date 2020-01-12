package meng.klj.upms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("tb_order_item")
public class OrderItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private String itemId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 商品购买数量
     */
    private Integer num;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品单价
     */
    private Long price;

    /**
     * 商品总金额
     */
    private Long totalFee;

    /**
     * 商品图片地址
     */
    private String picPath;


}
