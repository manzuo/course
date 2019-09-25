package com.management.course.service;

import com.management.course.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 返回所有用户
     * @return
     */
    List<User> findAll();
    /**
     * 通过工号查找id
     * @param workId
     * @return
     */
    User findByWorkId(String workId);
    /**
     *更新用户
     * @param user
     * @return
     */
    User update(User user);
}
