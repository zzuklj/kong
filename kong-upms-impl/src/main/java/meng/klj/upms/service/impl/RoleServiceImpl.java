package meng.klj.upms.service.impl;

import meng.klj.upms.entity.Role;
import meng.klj.upms.mapper.RoleMapper;
import meng.klj.upms.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
