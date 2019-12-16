package meng.klj.upms.service.impl;

import meng.klj.upms.entity.Permission;
import meng.klj.upms.mapper.PermissionMapper;
import meng.klj.upms.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
