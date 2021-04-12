package meng.klj.upms.controller;


import meng.klj.upms.entity.Category;
import meng.klj.upms.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import meng.klj.upms.service.ICategoryService;
import org.springframework.web.bind.annotation.RestController;
import meng.klj.common.base.BaseController;

/**
 * <p>
 * 内容分类 前端控制器
 * </p>
 *
 * @author klj
 * @since 2020-01-10
 */
@Api(tags = {"内容分类接口"})
@RestController
@RequestMapping("/api/category")
public class CategoryController extends BaseController {

  @Autowired
  private ICategoryService iCategoryService;

    @GetMapping("/get/{id}")
    public String getById(@PathVariable("id") Long id) {
        Category c = iCategoryService.getCateById(id);
        return "";
    }

}
