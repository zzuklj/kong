package meng.klj.upms.service.impl;

import meng.klj.upms.entity.UserOrganization;
import meng.klj.upms.mapper.UserOrganizationMapper;
import meng.klj.upms.service.IUserOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户组织关联表 服务实现类
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */

@Service
public class UserOrganizationServiceImpl extends ServiceImpl<UserOrganizationMapper, UserOrganization> implements IUserOrganizationService {

}
