package meng.klj.upms.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import meng.klj.upms.entity.User;
import meng.klj.upms.mapper.UserMapper;
import meng.klj.upms.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
}
