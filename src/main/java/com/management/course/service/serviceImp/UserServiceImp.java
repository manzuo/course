package com.management.course.service.serviceImp;

import com.management.course.dao.UserDao;
import com.management.course.entity.User;
import com.management.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/18 10:39
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByWorkId(String workId) {
        return userDao.findByWorkId(workId);
    }

    @Override
    public User update(User user) {
        return userDao.saveAndFlush(user);
    }
}
