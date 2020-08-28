package cn.edu.guet.system.service;

public interface ILoginService {
    Object login(String username, String password);
    Object getUserById(String username);
}
