package com.management.course.dao;

import com.management.course.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/18 10:37
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    /**
     * 通过工号查找id
     * @param workId
     * @return
     */
    User findByWorkId(String workId);
}
