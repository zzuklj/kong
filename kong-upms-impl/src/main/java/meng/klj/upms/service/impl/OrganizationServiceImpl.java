package meng.klj.upms.service.impl;

import meng.klj.upms.entity.Organization;
import meng.klj.upms.mapper.OrganizationMapper;
import meng.klj.upms.service.IOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 组织 服务实现类
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */

@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements IOrganizationService {

}
