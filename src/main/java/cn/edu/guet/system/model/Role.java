package cn.edu.guet.system.model;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private String roleId;
    private String roleName;
    private List<Menu> menus;
}
