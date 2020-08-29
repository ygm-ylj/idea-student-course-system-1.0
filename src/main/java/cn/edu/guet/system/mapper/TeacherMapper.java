package cn.edu.guet.system.mapper;

import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;
import cn.edu.guet.system.model.Student;
import cn.edu.guet.system.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {
    List<Course> getAllCourseId();
    Teacher getTeacherById(String teacherId);
    List<Course> viewCourseByTeacherId(@Param("teacherId") String teacherId);
    void addCourse(Course course);
    void deleteCourse(String courseId);
    Major getMajorByMajorId(String majorId);

    List<Student> viewStudentBycourseId(String courseId);
    List<Student> getAllStudentId();
    List<Major> getAllMajorId();
    void deleteStudents(String courseId, String studentId);
    void addStudents(String courseId, String studentId) throws Exception;
}
