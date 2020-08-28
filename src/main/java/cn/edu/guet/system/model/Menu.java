package cn.edu.guet.system.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Menu {
    private String menuId;
    private String pId;
    private String menuName;
    private String url;
    private Menu parentMenu;
    private List<Menu> childMenus=new ArrayList<Menu>();
}
