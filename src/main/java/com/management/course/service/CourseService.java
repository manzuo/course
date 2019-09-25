package com.management.course.service;

import com.management.course.entity.Course;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/10 22:54
 */
public interface CourseService {

    /** 插入课程
     * @param course
     * @return
     */
    Course save(Course course);

    /**
     * 更新课程
     * @param course
     * @return
     */
    Course update(Course course);
    /**
     * 通过老师名字获取课程
     * @param teacher
     * @return
     */
    List<Course> findByTeacher(String teacher);

    /**通过id获取课程
     * @param id
     * @return
     */
    Course findById(Integer id);
    /**
     * 通过选课代码名字获取课程
     * @param code
     * @return
     */
    Course findBySelectionCode(String code);
    /**
     * 通过学年获取课程
     * @param term
     * @return
     */
    List<Course> findByTerm(String term);
    /**
     * 通过学年和状态获取课程
     * @param term
     * @param state
     * @return
     */
    List<Course> findByTermAndState(String term,Integer state);
}
