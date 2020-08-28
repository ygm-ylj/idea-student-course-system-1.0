package cn.edu.guet.system.service;

import cn.edu.guet.system.model.Menu;

import java.util.List;

public interface IMenuService {
    List<Menu> getMenu();
    List<Menu> getMenuById(String username);
}
