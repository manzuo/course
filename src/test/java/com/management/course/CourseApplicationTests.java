package com.management.course;

import com.management.course.entity.Course;
import com.management.course.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseApplicationTests {
    @Autowired
    private CourseService courseService;
    @Test
    public void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
       Course course = new Course();
//        course.setCourseCode("222");
//        course.setCourseType("2222");
//        course.setPlace("222222");
//        course.setTeacher("1@222");
//        course.setTime("wwww");
//        course.setTitle("111111");
        course=courseService.findById(111);
        System.out.println(course);
    }
}
