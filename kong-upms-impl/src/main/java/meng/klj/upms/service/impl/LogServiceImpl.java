package meng.klj.upms.service.impl;

import meng.klj.upms.entity.Log;
import meng.klj.upms.mapper.LogMapper;
import meng.klj.upms.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author klj
 * @since 2019-12-16
 */

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
