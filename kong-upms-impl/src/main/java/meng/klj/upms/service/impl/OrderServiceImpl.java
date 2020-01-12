package meng.klj.upms.service.impl;

import meng.klj.upms.entity.Order;
import meng.klj.upms.mapper.OrderMapper;
import meng.klj.upms.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author klj
 * @since 2020-01-10
 */

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
