package meng.klj.upms.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import meng.klj.upms.service.ISystemService;
import org.springframework.web.bind.annotation.RestController;
import meng.klj.common.base.BaseController;

/**
 * <p>
 * 系统 前端控制器
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */
@Api(tags = {"系统接口"})
@RestController
@RequestMapping("/api/system")
public class SystemController extends BaseController {

  @Autowired
  private ISystemService iSystemService;

}
