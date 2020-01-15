package meng.klj.upms.mapper;

import meng.klj.upms.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author klj
 * @since 2020-01-10
 */
public interface OrderMapper extends BaseMapper<Order> {

    Long selectCurPayment();

    Long selectLastPayment();

    Integer selectCurOrderNum();

    Integer selectLastOrderNum();

    Integer selectCurRefundOrder();

    Integer selectLastRefundOrder();

    Integer selectDayOrderNum(Order order);

    Integer selectDayOrderSum(Order order);
}
