package com.management.course.service.serviceImp;

import com.management.course.dao.CourseDao;
import com.management.course.entity.Course;
import com.management.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author manzuo
 * @date 2019/9/11 10:21
 */
@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Override
    public Course save(Course course) {
        return courseDao.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseDao.saveAndFlush(course);
    }

    @Override
    public List<Course> findByTeacher(String teacher) {
        return courseDao.findByTeacher(teacher);
    }

    @Override
    public Course findById(Integer id) {
        return courseDao.findById(id).orElse(null);
    }

    @Override
    public Course findBySelectionCode(String code) {
        return courseDao.findBySelectionCode(code);
    }


    @Override
    public List<Course> findByTerm(String term) {
        return courseDao.findByTerm(term);
    }

    @Override
    public List<Course> findByTermAndState(String term, Integer state) {
        return courseDao.findByTermAndState(term,state);
    }

}
