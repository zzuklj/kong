package meng.klj.upms.service.impl;

import meng.klj.upms.entity.User;
import meng.klj.upms.mapper.UserMapper;
import meng.klj.upms.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
