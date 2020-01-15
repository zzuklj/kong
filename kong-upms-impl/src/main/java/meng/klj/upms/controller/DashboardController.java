package meng.klj.upms.controller;


import com.alibaba.fastjson.JSON;
import meng.klj.common.constants.DashboardKey;
import meng.klj.common.constants.KeyPrefix;
import meng.klj.common.tools.RunnableThreadWebCount;
import meng.klj.upms.entity.Order;
import meng.klj.upms.entity.Stats;
import meng.klj.upms.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 仪表板页面
 *
 * @param model
 * @return
 */

/**
 */
@Controller
public class DashboardController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/user/dashboard")
    public String dashboard(Model model, Stats stats) {

        Long mIncome, lastIncome;
        Integer curOrderNum, preOrderNum, curRefundOrder, lastRefundOrder, orderNum, orderSum;

        //全部加缓存
        mIncome = getValueFromRedis(DashboardKey.board , "mIncome", Long.class);
        if (mIncome == null) {
            mIncome = orderMapper.selectCurPayment();
            mIncome = mIncome == null ? 0L : mIncome;
            stringRedisTemplate.opsForValue().set(DashboardKey.board + "mIncome", mIncome.toString());
        }

        lastIncome = getValueFromRedis(DashboardKey.board , "lastIncome", Long.class);
        if (lastIncome == null) {
            lastIncome = orderMapper.selectLastPayment();
            lastIncome = lastIncome == null ? 0L : lastIncome;
            stringRedisTemplate.opsForValue().set(DashboardKey.board.getPrefix() + "lastIncome", lastIncome.toString());
        }

        curOrderNum = getValueFromRedis(DashboardKey.board, "curOrderNum", Integer.class);
        if (curOrderNum == null) {
            curOrderNum = orderMapper.selectCurOrderNum();
            curOrderNum = curOrderNum == null ? 0 : curOrderNum;
            stringRedisTemplate.opsForValue().set(DashboardKey.board.getPrefix() + "curOrderNum", curOrderNum.toString());
        }

        preOrderNum = getValueFromRedis(DashboardKey.board, "preOrderNum", Integer.class);
        if (preOrderNum == null) {
            preOrderNum = orderMapper.selectLastOrderNum();
            preOrderNum = preOrderNum == null ? 0 : preOrderNum;
            stringRedisTemplate.opsForValue().set(DashboardKey.board.getPrefix() + "preOrderNum", preOrderNum.toString());
        }

        curRefundOrder = getValueFromRedis(DashboardKey.board, "preOrderNum", Integer.class);
        if (curRefundOrder == null) {
            curRefundOrder = orderMapper.selectCurRefundOrder();
            curRefundOrder = curRefundOrder == null ? 0 : curRefundOrder;
            stringRedisTemplate.opsForValue().set(DashboardKey.board.getPrefix() + "curRefundOrder", curRefundOrder.toString());
        }

        lastRefundOrder = getValueFromRedis(DashboardKey.board, "lastRefundOrder", Integer.class);
        if (lastRefundOrder == null) {
            lastRefundOrder = orderMapper.selectLastRefundOrder();
            lastRefundOrder = lastRefundOrder == null ? 0 : lastRefundOrder;
            stringRedisTemplate.opsForValue().set(DashboardKey.board.getPrefix() + "lastRefundOrder", lastRefundOrder.toString());
        }

        int count = RunnableThreadWebCount.addCount("111");
        stats.setPv(count);//访问量
        stats.setOrderNumPer(getPer(curOrderNum, preOrderNum));//月订单数环比
        stats.setMOrderNum(orderMapper.selectCurOrderNum());//月订单数
        stats.setMIncome(mIncome);//月收入
        stats.setIncomePer(getPer(mIncome, lastIncome));//月收入环比
        stats.setMOrderRefund(orderMapper.selectCurRefundOrder());
        stats.setMOrderRefundPer(getPer(curRefundOrder, lastRefundOrder));

        model.addAttribute("dashboard", stats);

        List<Integer> data2 = new ArrayList<>();
        List<Integer> data3 = new ArrayList<>();

        Date now = new Date();
        //获取三十天前日期
        Order order = new Order();
        for (int i = 0; i < 31; i++) {
            order.setCreateTime(LocalDate.now().minusDays(30 - i).atStartOfDay());
            //每天的订单数
            orderNum = getValueFromRedis(DashboardKey.board, "orderNum", Integer.class);
            if (orderNum == null) {
                orderNum = orderMapper.selectDayOrderNum(order);
                orderNum = orderNum == null ? 0 : orderNum;
                stringRedisTemplate.opsForValue().set(DashboardKey.board.getPrefix() + "orderNum", orderNum.toString());
            }

            //每天的收入
            orderSum = getValueFromRedis(DashboardKey.board, "orderSum", Integer.class);
            if (orderSum == null) {
                orderSum = orderMapper.selectDayOrderSum(order);
                orderSum = orderSum == null ? 0 : orderSum;
                stringRedisTemplate.opsForValue().set(DashboardKey.board.getPrefix() + "orderSum", orderSum.toString());
            }
            data2.add(orderNum);
            data3.add(orderSum);
        }

        model.addAttribute("data2", data2);
        model.addAttribute("data3", data3);
        return "dashboard";
    }

    public String getPer(long a, long b) {
        StringBuilder orderNumPer = new StringBuilder();
        double differ = a - b;
        double d = differ / a;
        String s = String.format("%.2f", d);
        orderNumPer.append(s).append("%");
        return orderNumPer.toString();
    }

    @RequestMapping(value = "/border/website/count/")
    @ResponseBody
    public int count(@RequestParam("key") String key) {
        return RunnableThreadWebCount.addCount(key);
    }

    private <T> T getValueFromRedis(KeyPrefix prefix, String keySuf , Class<T> t){
        String value = stringRedisTemplate.opsForValue().get(prefix.getPrefix() + keySuf);
        T v = JSON.parseObject(value, t);
        return v;
    }
}