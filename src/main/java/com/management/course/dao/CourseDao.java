package com.management.course.dao;

import com.management.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/18 10:37
 */
@Repository
public interface CourseDao extends JpaRepository<Course,Integer>, JpaSpecificationExecutor<Course> {
    /**
     * 通过老师名字获取课程
     * @param teacher
     * @return
     */
    List<Course> findByTeacher(String teacher);
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
