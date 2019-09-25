package com.management.course.service;

import com.management.course.entity.Role;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/25 0:00
 */
public interface RoleService {
    /**
     * 通过roleId返回角色
     * @param roleId
     * @return
     */
    Role findByRoleId(String roleId);
}
