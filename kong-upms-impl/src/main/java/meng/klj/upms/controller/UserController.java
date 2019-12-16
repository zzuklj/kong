package meng.klj.upms.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import meng.klj.upms.service.IUserService;
import org.springframework.web.bind.annotation.RestController;
import meng.klj.common.base.BaseController;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */
@Api(tags = {"用户接口"})
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

  @Autowired
  private IUserService iUserService;

}
