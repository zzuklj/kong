package meng.klj.upms.service.impl;

import meng.klj.upms.entity.UserPermission;
import meng.klj.upms.mapper.UserPermissionMapper;
import meng.klj.upms.service.IUserPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户权限关联表 服务实现类
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */

@Service
public class UserPermissionServiceImpl extends ServiceImpl<UserPermissionMapper, UserPermission> implements IUserPermissionService {

}
