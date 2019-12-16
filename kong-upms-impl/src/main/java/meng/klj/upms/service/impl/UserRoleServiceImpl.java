package meng.klj.upms.service.impl;

import meng.klj.upms.entity.UserRole;
import meng.klj.upms.mapper.UserRoleMapper;
import meng.klj.upms.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
