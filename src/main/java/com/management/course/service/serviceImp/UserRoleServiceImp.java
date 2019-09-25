package com.management.course.service.serviceImp;

import com.management.course.dao.UserRoleDao;
import com.management.course.entity.UserRole;
import com.management.course.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/25 0:11
 */
@Service
public class UserRoleServiceImp implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;
    @Override
    public List<UserRole> findByRoleId(String roleId) {
        return userRoleDao.findByRoleId(roleId);
    }

    @Override
    public List<UserRole> findByWorkId(String workId) {
        return userRoleDao.findByWorkId(workId);
    }

    @Override
    public void deleteByWorkId(String workId) {
        userRoleDao.deleteByWorkId(workId);
    }
}
