package meng.klj.upms.service.impl;

import meng.klj.upms.entity.System;
import meng.klj.upms.mapper.SystemMapper;
import meng.klj.upms.service.ISystemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统 服务实现类
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */

@Service
public class SystemServiceImpl extends ServiceImpl<SystemMapper, System> implements ISystemService {

}
