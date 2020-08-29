package cn.edu.guet.system.service;

import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;
import cn.edu.guet.system.model.Student;
import cn.edu.guet.system.model.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Course> getAllCourseId();
    Teacher getTeacherById(String teacherId);

    List<Course> viewCourseByTeacherId(String teacherId);
    void addCourse(Course course) throws Exception;
    void deleteCourse(String courseId) throws Exception;
    Major getMajorByMajorId(String majorId);

    List<Student> viewStudentBycourseId(String courseId);
    List<Student> getAllStudentId();
    List<Major> getAllMajorId();
    void deleteStudents(String courseId, String studentId);
    void addStudents(String courseId, String studentId) throws Exception;
}
