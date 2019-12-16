package meng.klj.upms.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import meng.klj.upms.service.IUserOrganizationService;
import org.springframework.web.bind.annotation.RestController;
import meng.klj.common.base.BaseController;

/**
 * <p>
 * 用户组织关联表 前端控制器
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */
@Api(tags = {"用户组织关联表接口"})
@RestController
@RequestMapping("/api/user-organization")
public class UserOrganizationController extends BaseController {

  @Autowired
  private IUserOrganizationService iUserOrganizationService;

}
