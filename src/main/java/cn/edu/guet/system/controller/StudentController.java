package cn.edu.guet.system.controller;

import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.model.Major;
import cn.edu.guet.system.service.IStudentService;
import cn.edu.guet.system.service.impl.AuthenticationImpl;
import cn.edu.guet.system.util.GetUsername;
import cn.edu.guet.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    IStudentService studentService;
    @Autowired
    GetUsername getUsername;
    @Autowired
    AuthenticationImpl authentication;

    @GetMapping("ChooseCourse")
    public Result ChooseCourse(String majorid, HttpServletRequest request){
        System.out.println("获取到专业"+majorid);
        String studentid = authentication.getUsername(request, "ChooseCourse");
        System.out.println("获取到用户id"+studentid);
        List<Course> courseList=studentService.getCourse(majorid,studentid);
        System.out.println(courseList);
        return Result.succ(courseList);
    }

    @GetMapping("ChooseMajor")
    public Result ChooseMajor(){
        List<Major> majorList=studentService.getMajor();
        return Result.succ(majorList);
    }

    @GetMapping("CourseSelection")
    public Result CourseSelection(String courseid, HttpServletRequest request){
        String studentid = authentication.getUsername(request, "ChooseCourse");
        studentService.courseSelection(courseid,studentid);
        return Result.succ("选课成功");
    }
}
