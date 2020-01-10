package meng.klj.upms.service.impl;

import meng.klj.upms.entity.Item;
import meng.klj.upms.mapper.ItemMapper;
import meng.klj.upms.service.IItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author klj
 * @since 2020-01-10
 */

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

}
