package cn.edu.guet.system.controller;


import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;
import cn.edu.guet.system.model.Student;
import cn.edu.guet.system.model.Teacher;
import cn.edu.guet.system.service.ITeacherService;
import cn.edu.guet.system.service.impl.AuthenticationImpl;
import cn.edu.guet.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TCourseController {

    @Autowired
    ITeacherService teacherService;
    @Autowired
    AuthenticationImpl authentication;
    Result result = new Result();
    //添加课程
    //@RequestMapping(value = "/addCoursess",method = RequestMethod.GET)
    @GetMapping("AddTeaching")
    public Result addCourse(String courseId, String courseName, String majorId, HttpServletRequest request) {
        String teacherId = authentication.getUsername(request,"AddTeaching");
        Course course = new Course();
        List allCourseId=teacherService.getAllCourseId();
        List allMajorId=teacherService.getAllMajorId();
        System.out.println("aaaaaaaaaaa"+majorId);
        try {
            Major major=teacherService.getMajorByMajorId(majorId);
            Teacher teacher=teacherService.getTeacherById(teacherId);
            course.setCourseId(courseId);
            course.setCourseName(courseName);
            course.setTeacher(teacher);
            course.setMajor(major);
            teacherService.addCourse(course);
            return result.succ(200, "课程添加成功", null);
        }catch (Exception e){
            e.printStackTrace();
            if (allCourseId.contains(courseId)){
                return result.fail("课程已存在");
            }else if (!allMajorId.contains(majorId)){
                return result.fail("没有这专业");
            }
        }
        return null;
    }
    //添加学生
    //@RequestMapping(value = "/addStudents", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @GetMapping("addStudents")
    public Result addStudent(String courseId, String studentId){
        List<Student> allStudentId=teacherService.getAllStudentId();
        List<Course> allcourseid=teacherService.getAllCourseId();
        try {
            teacherService.addStudents(courseId,studentId);
            return result.succ(200,"添加学生成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            if(!allStudentId.contains(studentId)){
                return result.fail("学生不存在");
            }
        }
        return  null;
    }
    //通过老师Id查找课程
    //@RequestMapping(value = "/viewCourseByTeacherId",method = RequestMethod.GET)
    @GetMapping("ViewTeaching")
    public Result viewCourseByTeacherId(HttpServletRequest request){

        String teacherId = authentication.getUsername(request,"ViewTeaching");
        List<Course> teacherCourses=teacherService.viewCourseByTeacherId(teacherId);
        if (teacherCourses == null) {
            return result.fail("老师暂时没有课程");
        }
        else{
            return result.succ(200, "查询课程成功", teacherCourses);
        }
    }
    //删除课程
    //@RequestMapping(value = "/deleteCourses",method = RequestMethod.GET)
    @GetMapping("deleteCourses")
    public Result deleteCourse(String courseId){
        System.out.println(courseId);
        try {
            teacherService.deleteCourse(courseId);
            return result.succ(200,"删除课程成功",null);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("课程ID不存在或存在子记录");
        }
    }
    //通过courseId查询学生
    //@RequestMapping(value = "/viewStudentByCourseId", method = RequestMethod.GET)
    @GetMapping("viewStudentByCourseId")
    public Result getStudentByCourseId(String courseId){
        List<Student> studentList=teacherService.viewStudentBycourseId(courseId);
        if (studentList == null) {
            return result.fail("该课还没有学生选课");
        }
        return result.succ(studentList);
    }
    //删除学生
    //@RequestMapping(value = "/deleteStudents", method = RequestMethod.GET)
    @GetMapping("deleteStudents")
    public Result deleteStudents(String courseId,
                                 String studentId){
            teacherService.deleteStudents(courseId,studentId);
            return result.succ(200,"学生删除成功",null);
    }
}
