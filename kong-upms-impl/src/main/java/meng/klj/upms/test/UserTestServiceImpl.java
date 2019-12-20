package meng.klj.upms.test;

import meng.klj.upms.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserTestServiceImpl implements IUserTestService {

    @Override
    @Transactional
    public User getById(Long id) {
        User user = new User();
        user.setId(id);
        user.setUsername("klj");
        return user;
    }
}
