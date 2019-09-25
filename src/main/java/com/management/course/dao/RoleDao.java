package com.management.course.dao;

import com.management.course.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/24 23:30
 */
@Repository
public interface RoleDao extends JpaRepository<Role,Integer>, JpaSpecificationExecutor<Role> {
    /**
     * 通过roleId返回角色
     * @param roleId
     * @return
     */
    Role findByRoleId(String roleId);
}
