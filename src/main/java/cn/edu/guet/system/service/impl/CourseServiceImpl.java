package cn.edu.guet.system.service.impl;

import cn.edu.guet.system.mapper.CourseMapper;
import cn.edu.guet.system.model.Course;
import cn.edu.guet.system.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> getCourse(String studentId) {
        List<Course> cou=courseMapper.getCourseById(studentId);//用studentId从courseMapper获得getCourseById并赋值给cou集合
        return cou;
    }

    @Override
    public void deleteCourse(String studentId, String courseId) throws Exception {
        courseMapper.deleteCourse(studentId,courseId);//调用Mapper层deleteCourse函数并传入studentId和 courseId
    }
}


