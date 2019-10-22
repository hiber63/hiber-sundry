package cn.hiber.sec.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hiber
 */
@Configuration
public class HiberShiroConfig {

    @Bean
    public AuthorizingRealm secRealm() {
        AuthorizingRealm realm = new HiberSecReamSimple(); //only for demo
//        AuthorizingRealm realm = new HiberSecReam();
        return realm;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //rest api or jsp
        shiroFilterFactoryBean.setLoginUrl("/shiro/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/shiro/unAuthrized");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(AuthorizingRealm secRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(secRealm);
        return securityManager;
    }

}
