package cn.edu.guet.system.mapper;

import cn.edu.guet.system.model.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<Course> getCourse(@Param("majorid") String majorid, @Param("studentid") String studentid);
    Boolean courseSelection(@Param("courseid") String courseid, @Param("studentid") String studentid);
    List<Course> getCourseAll(String teacherid);
}
