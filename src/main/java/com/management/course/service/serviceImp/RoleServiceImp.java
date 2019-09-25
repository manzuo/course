package com.management.course.service.serviceImp;

import com.management.course.dao.RoleDao;
import com.management.course.entity.Role;
import com.management.course.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/25 0:13
 */
@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public Role findByRoleId(String roleId) {
        return roleDao.findByRoleId(roleId);
    }
}
