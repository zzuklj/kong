package meng.klj.upms.service.impl;

import meng.klj.upms.entity.OrderItem;
import meng.klj.upms.mapper.OrderItemMapper;
import meng.klj.upms.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author klj
 * @since 2020-01-10
 */

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService  {

    @Transactional
    public void updateItem(){
        OrderItem updateOne = new OrderItem();
        updateOne.setId(2L);
        updateOne.setNum(2);
        updateById(updateOne);
    }
}
