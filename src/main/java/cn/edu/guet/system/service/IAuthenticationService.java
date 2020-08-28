package cn.edu.guet.system.service;

import javax.servlet.http.HttpServletRequest;

public interface IAuthenticationService {
    String getUsername(HttpServletRequest request, String url);
}
