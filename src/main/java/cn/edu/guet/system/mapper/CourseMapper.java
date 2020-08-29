package cn.edu.guet.system.mapper;


import cn.edu.guet.system.model.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    List<Course> getCourseById(String studentId);//传入studentId,利用studentId查出已选课程
    //传入当前用户的studentId和courseId
    void deleteCourse(@Param("studentId") String studentId, @Param("courseId") String courseId);
}
