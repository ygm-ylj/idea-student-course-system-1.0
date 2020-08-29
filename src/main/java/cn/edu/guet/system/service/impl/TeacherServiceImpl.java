package cn.edu.guet.system.service.impl;

import cn.edu.guet.system.mapper.TeacherMapper;
import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;
import cn.edu.guet.system.model.Student;
import cn.edu.guet.system.model.Teacher;
import cn.edu.guet.system.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Override
    public List<Course> getAllCourseId() {
        List<Course> allCourse = teacherMapper.getAllCourseId();
        List allCourseId = new ArrayList();
        for (int i = 0; i < allCourse.size(); i++) {
            allCourseId.add(allCourse.get(i).getCourseId());
        }
        return allCourseId;
    }
    @Override
    public Teacher getTeacherById(String teacherId) {
        Teacher teacher=teacherMapper.getTeacherById(teacherId);
        return teacher;
    }
    @Override
    public List<Course> viewCourseByTeacherId(String teacherId) {
        List<Course> teaCourses=teacherMapper.viewCourseByTeacherId(teacherId);
        System.out.println(teaCourses);
        return teaCourses;
    }
    @Override
    public void addCourse(Course course) throws Exception {
        teacherMapper.addCourse(course);
    }
    @Override
    public void deleteCourse(String courseId) throws Exception{
        teacherMapper.deleteCourse(courseId);
    }
    @Override
    public Major getMajorByMajorId(String majorId) {
        Major major=teacherMapper.getMajorByMajorId(majorId);
        return major;
    }

    @Override
    public List<Student> viewStudentBycourseId(String courseId) {
        List<Student> studentList = teacherMapper.viewStudentBycourseId(courseId);
        return studentList;
    }

    @Override
    public List<Student> getAllStudentId() {
        List<Student> allStudent=teacherMapper.getAllStudentId();
        List allStudentId=new ArrayList();
        for(int i=0;i<allStudent.size();i++){
            allStudentId.add(allStudent.get(i).getStudentId());
        }
        return allStudentId;
    }

    @Override
    public List<Major> getAllMajorId() {
        List<Major> allMajor=teacherMapper.getAllMajorId();
        List allMajorId=new ArrayList();
        for(int i=0;i<allMajor.size();i++){
            allMajorId.add(allMajor.get(i).getMajorId());
        }
        return allMajorId;
    }

    @Override
    public void deleteStudents(String courseId, String studentId) {
        teacherMapper.deleteStudents(courseId,studentId);
    }

    @Override
    public void addStudents(String courseId, String studentId) throws Exception {
        teacherMapper.addStudents(courseId,studentId);
    }
}
