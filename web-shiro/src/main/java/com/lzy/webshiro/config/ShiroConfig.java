package com.lzy.webshiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        logger.info("启动shiroFilter--时间是：" + new Date());
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 设置访问未登录跳转的界面
        //1.需要认证（authc）的请求，在没有登录的情况下都会跳转到这个页面；2.登录失败会跳转到这个页面；3.退出过滤器（logout）拦截后跳转到这个页面
        //通常我们使用shiro，登录之后就会跳到我们上一次访问的URL，如果我们是直接访问登录页面的话，shiro就会根据我们配置的successUrl去重定向，
        // 如果我们没有配置successUrl的话，那么shiro重定向默认的/
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 设置登录成功后要跳转的链接,不配置则跳转至”/”
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //设置访问未授权要跳转的界面,perms，roles，ssl，rest，port这几种过滤器拦截的请求授权失败才会跳到/unauth
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauth");

        //shiro拦截器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->

        // 配置不被拦截的资源及链接
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login", "authc");//登录页要设置authc过滤器，才会有登录成功后自动跳到SuccessUrl设置的页面
        // 退出过滤器
        filterChainDefinitionMap.put("/logout", "logout");//拦截/logout的请求，清除session，并跳转到LoginUrl配置的页面
        //配置需要认证权限的
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //注入Realm,用于用户登录和访问授权
        securityManager.setRealm(myShiroRealm());
        //注入缓存管理器，用户缓存用户权限信息
        securityManager.setCacheManager(ehCacheManager());
        return securityManager;
    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }
    /**
     * 缓存管理器 使用Ehcache实现
     */
    @Bean
    public EhCacheManager ehCacheManager() {
        net.sf.ehcache.CacheManager cacheManager = net.sf.ehcache.CacheManager.getCacheManager("lzy");
        EhCacheManager em = new EhCacheManager();
        if (cacheManager==null)
        {
            String configFile = "classpath:ehcache/ehcache-shiro.xml";
            InputStream in= null;
            try {
                in = ResourceUtils.getInputStreamForPath(configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            em.setCacheManager(new net.sf.ehcache.CacheManager(in));
            return em;
        }
        else
        {
            em.setCacheManager(cacheManager);
            return em;
        }
    }


    /**
     * 开启shiro aop注解支持，不开启的话权限验证就会失效
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * thymeleaf模板引擎和shiro框架的整合
     */
    @Bean
    public ShiroDialect shiroDialect()
    {
        return new ShiroDialect();
    }

}
