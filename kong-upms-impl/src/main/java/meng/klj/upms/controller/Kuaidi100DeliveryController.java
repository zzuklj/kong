package meng.klj.upms.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import meng.klj.upms.service.IKuaidi100DeliveryService;
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
@Api(tags = {"接口"})
@RestController
@RequestMapping("/api/kuaidi100-delivery")
public class Kuaidi100DeliveryController extends BaseController {

  @Autowired
  private IKuaidi100DeliveryService iKuaidi100DeliveryService;

}
