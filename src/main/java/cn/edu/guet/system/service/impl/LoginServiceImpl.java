package cn.edu.guet.system.service.impl;

import cn.edu.guet.system.exception.LoginException;
import cn.edu.guet.system.mapper.LoginMapper;
import cn.edu.guet.system.model.Student;
import cn.edu.guet.system.model.Teacher;
import cn.edu.guet.system.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public Object login(String username, String password) throws LoginException{
        System.out.println("事务处理"+username);
        System.out.println("事务处理"+password);
        try {
            if (username.length()==6){
                Teacher teacher=loginMapper.loginTeacher(username,password);
                return teacher;
            }
            else if (username.length()==10){
                Student student=loginMapper.loginStudent(username,password);
                return student;
            }
            else if ("17007".equals(username) && "17007".equals(password)){
                return "R003";
            }
        }
        catch (Exception e){

            throw new LoginException("登陆失败，请检查用户名密码是否正确");
        }
        return null;
    }

    @Override
    public Object getUserById(String username) {

        return null;
    }
}
