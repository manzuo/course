package com.management.course.dao;

import com.management.course.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/24 23:31
 */
@Repository
public interface UserRoleDao extends JpaRepository<UserRole,Integer>, JpaSpecificationExecutor<UserRole> {
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
