package cn.edu.guet.system.mapper;

import cn.edu.guet.system.model.Student;
import cn.edu.guet.system.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    Student loginStudent(@Param("username") String username, @Param("password") String password);
    Teacher loginTeacher(@Param("username") String username, @Param("password") String password);
}
