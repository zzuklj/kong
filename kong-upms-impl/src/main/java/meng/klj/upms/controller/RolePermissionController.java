package meng.klj.upms.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import meng.klj.upms.service.IRolePermissionService;
import org.springframework.web.bind.annotation.RestController;
import meng.klj.common.base.BaseController;

/**
 * <p>
 * 角色权限关联表 前端控制器
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */
@Api(tags = {"角色权限关联表接口"})
@RestController
@RequestMapping("/api/role-permission")
public class RolePermissionController extends BaseController {

  @Autowired
  private IRolePermissionService iRolePermissionService;

}
