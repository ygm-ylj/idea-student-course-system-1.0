package cn.edu.guet.system.mapper;

import cn.edu.guet.system.model.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    List<Menu> getMenuById(@Param("roleid") String roleid);
    List<Menu> getChildMenuById(String id);
    List<Menu> getAllMenus();
}
