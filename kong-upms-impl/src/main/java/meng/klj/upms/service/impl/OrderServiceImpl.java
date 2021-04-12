package meng.klj.upms.service.impl;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import meng.klj.upms.entity.Order;
import meng.klj.upms.mapper.OrderMapper;
import meng.klj.upms.service.IOrderItemService;
import meng.klj.upms.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import sun.nio.ch.ThreadPool;

import java.time.LocalDateTime;
import java.util.concurrent.*;

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

    @Autowired
    private IOrderItemService orderItemService;

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("test-pool-%d").build();

    private static ExecutorService executorService = new ThreadPoolExecutor(3, 10,
            30L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    @Override
    @Transactional
    public void multiThreadTrans() {
        Order updateOrder = new Order();
        updateOrder.setOrderId("31");
        updateOrder.setUpdateTime(LocalDateTime.now());
        updateOrder.setPayment("38");
        updateById(updateOrder);

        executorService.execute(() -> {
            orderItemService.updateItem();
        });
    }
}
