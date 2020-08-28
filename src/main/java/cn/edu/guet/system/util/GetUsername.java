package cn.edu.guet.system.util;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
public class GetUsername {
    @Autowired
    JwtUtils jwtUtils;

    public String getUsername(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        Claims claims = jwtUtils.getClaimByToken(token);
        return claims.getSubject();
    }
}
