package meng.klj.upms.service;

import meng.klj.upms.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author klj
 * @since 2020-01-10
 */
public interface IUserService extends IService<User> {

    User selectByNameAndPwd(User user);

    void selectIsName(User user);
}
