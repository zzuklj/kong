package meng.klj.upms.entity;

/**
 * Created by jiangyunxiong on 2018/3/27.
 */

import lombok.Data;

/**
 * 统计类
 */
@Data
public class Stats {

    /**
     * 月收入
     */
    private long mIncome;
    /**
     * 月收入环比
     */
    private String incomePer;

    /**
     * 月订单数
     * @return
     */

    private int mOrderNum;
    /**
     * 月订单数环比
     */
    private String orderNumPer;

    /**
     * 月退单
     * @return
     */
    private int mOrderRefund;
    /**
     * 月退单
     * @return
     */
    private String mOrderRefundPer;

    /**
     * 访问量
     * @return
     */
    private int pv;

}
