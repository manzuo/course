package com.management.course.service.serviceImp;


import com.management.course.dao.RolePermissionDao;
import com.management.course.entity.RolePermission;
import com.management.course.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/25 0:05
 */
@Service
public class RolePermissionServiceImp implements RolePermissionService {
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Override
    public List<RolePermission> findByPermissionId(String permissionId) {
        return rolePermissionDao.findByPermissionId(permissionId);
    }

    @Override
    public List<RolePermission> findByRoleId(String roleId) {
        return rolePermissionDao.findByRoleId(roleId);
    }

    @Override
    public void deleteByRoleId(String roleId) {
        rolePermissionDao.deleteByRoleId(roleId);
    }
}
