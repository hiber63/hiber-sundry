package cn.hiber.sec.shiro;

import cn.hiber.sec.entity.HiberUser;
import cn.hiber.sec.repository.HiberUserRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hiber
 */
public class HiberSecReamSimple extends AuthorizingRealm {

    @Autowired
    HiberUserRepository userRepository;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        HiberUser user = userRepository.findByUsername(((UsernamePasswordToken) authenticationToken).getUsername());
        if(user!=null) {
            PrincipalCollection c = new SimplePrincipalCollection(new HiberPrincipal(user.getId(),user.getUsername()), getName());
            return new SimpleAuthenticationInfo(c, user.getPassword());
        } else {
            throw new UnknownAccountException();
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
