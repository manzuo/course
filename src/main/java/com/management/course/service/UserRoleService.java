package com.management.course.service;

import com.management.course.entity.UserRole;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/25 0:02
 */
public interface UserRoleService {
    /**
     * 通过roleId查找
     * @param roleId
     * @return
     */
    List<UserRole> findByRoleId(String roleId);

    /**
     * 通过workId查找
     * @param workId
     * @return
     */
    List<UserRole> findByWorkId(String workId);
    /**
     * 删除用户角色
     * @param workId
     */
    void deleteByWorkId(String workId);
}
