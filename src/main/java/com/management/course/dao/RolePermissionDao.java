package com.management.course.dao;

import com.management.course.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/24 23:30
 */
@Repository
public interface RolePermissionDao extends JpaRepository<RolePermission,Integer>, JpaSpecificationExecutor<RolePermission> {
    /**
     * 通过permissionId获取
     * @param permissionId
     * @return
     */
    List<RolePermission> findByPermissionId(String permissionId);

    /**
     * 通过roleId获取
     * @param roleId
     * @return
     *
     */
    List<RolePermission> findByRoleId(String roleId);

    /**
     * 通过roleId删除
     * @param roleId
     */
    void deleteByRoleId(String roleId);
}
