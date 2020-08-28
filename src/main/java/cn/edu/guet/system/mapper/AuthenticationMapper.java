package cn.edu.guet.system.mapper;

import cn.edu.guet.system.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationMapper {
    Role identity(@Param("roleid")String roleid, @Param("url")String url);
}
