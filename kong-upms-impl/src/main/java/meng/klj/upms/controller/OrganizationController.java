package meng.klj.upms.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import meng.klj.upms.service.IOrganizationService;
import org.springframework.web.bind.annotation.RestController;
import meng.klj.common.base.BaseController;

/**
 * <p>
 * 组织 前端控制器
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */
@Api(tags = {"组织接口"})
@RestController
@RequestMapping("/api/organization")
public class OrganizationController extends BaseController {

  @Autowired
  private IOrganizationService iOrganizationService;

}
