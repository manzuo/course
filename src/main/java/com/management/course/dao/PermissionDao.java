package com.management.course.dao;

import com.management.course.entity.Permission;
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
public interface PermissionDao extends JpaRepository<Permission,Integer>, JpaSpecificationExecutor<Permission> {
}
