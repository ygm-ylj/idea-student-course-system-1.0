package cn.edu.guet.system.service.impl;

import cn.edu.guet.system.exception.PermissionException;
import cn.edu.guet.system.mapper.AuthenticationMapper;
import cn.edu.guet.system.model.Role;
import cn.edu.guet.system.service.IAuthenticationService;
import cn.edu.guet.system.util.GetRole;
import cn.edu.guet.system.util.GetUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthenticationImpl implements IAuthenticationService {

    @Autowired
    AuthenticationMapper authenticationMapper;
    @Autowired
    GetUsername getUsername;


    @Override
    public String getUsername(HttpServletRequest request, String url) throws PermissionException{
        String username = getUsername.getUsername(request);
        System.out.println("当前用户：" + username + " 操作：" + url);
        String roleid = GetRole.getRole(username);
        System.out.println(roleid);
        Role role = authenticationMapper.identity(roleid,url);
        if (role!=null){
            return username;
        }else {
            throw new PermissionException("权限不足，请联系管理员");
        }
    }
}
