package meng.klj.upms.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import meng.klj.upms.service.IItemService;
import org.springframework.web.bind.annotation.RestController;
import meng.klj.common.base.BaseController;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author klj
 * @since 2020-01-10
 */
@Api(tags = {"商品表接口"})
@RestController
@RequestMapping("/api/item")
public class ItemController extends BaseController {

  @Autowired
  private IItemService iItemService;

}
