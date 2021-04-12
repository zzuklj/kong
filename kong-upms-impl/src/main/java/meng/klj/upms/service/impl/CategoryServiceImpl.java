package meng.klj.upms.service.impl;

import meng.klj.upms.entity.Category;
import meng.klj.upms.mapper.CategoryMapper;
import meng.klj.upms.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Category getCateById(Long id) {
        return categoryMapper.selectById(id);
    }

    public void save(Category category) {
        categoryMapper.insert(category);
    }
}
