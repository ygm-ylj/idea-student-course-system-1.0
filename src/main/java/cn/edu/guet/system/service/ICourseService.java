package cn.edu.guet.system.service;

import cn.edu.guet.system.model.Course;

import java.util.List;


public interface ICourseService {
    List<Course> getCourse(String studentId);//獲取
    void deleteCourse(String studentId, String courseId) throws Exception;
}
