package meng.klj.upms.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import javafx.util.Builder;
import meng.klj.upms.entity.Category;
import meng.klj.upms.entity.User;
import meng.klj.upms.mapper.UserMapper;
import meng.klj.upms.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author klj
 * @since 2020-01-10
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    CategoryServiceImpl categoryService;

    @Override
    public User selectByNameAndPwd(User user) {
        User one = getOne(Wrappers.<User>lambdaQuery()
                .eq(User::getUserName, user.getUserName())
                .eq(User::getPassword, user.getPassword()));
        return one;
    }

    @Override
    public void selectIsName(User user) {
        User one = getOne(Wrappers.<User>lambdaQuery()
                .eq(User::getUserName, user.getUserName()));
        if(Objects.isNull(one)){
            throw new RuntimeException("");
        }
    }

    @Override
    @Transactional
    public void add(User user) {

       addCategory();

        save(user);
    }

    @Override
    public void add2(User user) {
        addCategory();
        save(user);
    }

    private void addCategory(){
        Category category = new Category();
        category.setId(12345L);
        category.setName("testCate");
        categoryService.save(category);
    }
}
