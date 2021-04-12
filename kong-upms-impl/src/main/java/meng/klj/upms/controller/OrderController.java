package meng.klj.upms.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import meng.klj.upms.service.IOrderService;
import org.springframework.web.bind.annotation.RestController;
import meng.klj.common.base.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author klj
 * @since 2020-01-10
 */
@Api(tags = {"订单接口"})
@RestController
@RequestMapping("/api/order")
public class OrderController extends BaseController {

  @Autowired
  private IOrderService iOrderService;

  @GetMapping("/multi-thread/trans")
  public String multiThreadTrans(){
      iOrderService.multiThreadTrans();
      return "success";
  }

}
