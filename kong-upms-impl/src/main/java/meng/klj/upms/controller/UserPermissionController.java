package meng.klj.upms.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import meng.klj.upms.service.IUserPermissionService;
import org.springframework.web.bind.annotation.RestController;
import meng.klj.common.base.BaseController;

/**
 * <p>
 * 用户权限关联表 前端控制器
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */
@Api(tags = {"用户权限关联表接口"})
@RestController
@RequestMapping("/api/user-permission")
public class UserPermissionController extends BaseController {

  @Autowired
  private IUserPermissionService iUserPermissionService;

}
