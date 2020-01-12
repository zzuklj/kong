package meng.klj.upms.service.impl;

import meng.klj.upms.entity.Category;
import meng.klj.upms.mapper.CategoryMapper;
import meng.klj.upms.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内容分类 服务实现类
 * </p>
 *
 * @author klj
 * @since 2020-01-10
 */

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
