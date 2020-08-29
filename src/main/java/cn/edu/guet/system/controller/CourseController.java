package cn.edu.guet.system.controller;

import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.service.IAuthenticationService;
import cn.edu.guet.system.service.ICourseService;
import cn.edu.guet.system.service.impl.AuthenticationImpl;
import cn.edu.guet.system.util.Result;
import oracle.net.ano.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CourseController {
    //这里需要一个courseService类型的属性，通过@Autowired自动装配方式，从IoC容器中去查找到，并返回给该属性(要去IOC容器中先配好)
    @Autowired
    ICourseService courseService;

    @Autowired
    IAuthenticationService authentication;


    //从前端发来获得查看当前用户已选课程的请求
    @RequestMapping(value = "ViewSelected",method = RequestMethod.GET)
    //传入httpSession
    public Result getCourse(HttpServletRequest request){
        //String studentId = (String) httpSession.getAttribute("username");//从http中获得username并赋值给studentId
        String studentId = authentication.getUsername(request, "ViewSelected");
        System.out.println("AAAAAAAAAAAAAAABBBBBBBBBBBBB取到的当前用户："+studentId);
        Result result=new Result();
        List<Course> cou=courseService.getCourse(studentId);//用studentId从courseService中获得getCourse并赋值给cou集合
        System.out.println(cou);
        if(cou!=null){
            return result.succ(cou);//如果cou不为空，便将cou集合返回
        }else {
            return result.fail("没有选课");//如果cou为空则当前学生没有选课
        }
    }


    //前端发来退课请求
    @RequestMapping(value = "deleteCourse",method = RequestMethod.GET)
    //传入httpSession和从前端发来的courseId
    public Result deleteCourse(HttpServletRequest request,String courseId){
        Result result=new Result();
        try{
            /*String studentId = (String) httpSession.getAttribute("username");从httpSession中获得当前用户并赋值给studentid*/
            String studentId = authentication.getUsername(request, "ViewSelected");
            System.out.println("获取到的当前正在操作的用户username："+studentId);
            System.out.println("从前端发来的courseId:"+courseId);
            courseService.deleteCourse(studentId,courseId);//调用courseService的deleteCourse函数并传过去studentId和courseId
        }catch (Exception e){
            e.printStackTrace();
            return result.fail("退课失败，请联系管理员");//出了异常给前端返回退课失败
        }
        return result.succ("退课成功");//没有异常退课成功则返回退课成功
    }
}
