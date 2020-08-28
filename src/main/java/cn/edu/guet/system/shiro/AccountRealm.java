package cn.edu.guet.system.shiro;

import cn.edu.guet.system.service.ILoginService;
import cn.edu.guet.system.util.JwtUtils;
import cn.hutool.core.bean.BeanUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    ILoginService loginService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        JwtToken jwtToken = (JwtToken) token;

        String username = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        if (username == null) {
            throw new UnknownAccountException("账户不存在");
        }


        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(username, profile);

        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
    }
}
