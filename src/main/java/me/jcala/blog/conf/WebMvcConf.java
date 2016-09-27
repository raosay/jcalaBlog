package me.jcala.blog.conf;

import me.jcala.blog.interceptor.UserSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2016/9/11.
 */
@Configuration
public class WebMvcConf extends WebMvcConfigurerAdapter{
    @Value("${reverse.domain}")
    private String reverse_domain;
    @Value("${reverse.port}")
    private String reverse_port;
    @Value("${reverse.prefix}")
    private String reverse_prefix;
    @Value("${reverse.path}")
    private String reverse_path;
    @Autowired
    private UserSecurityInterceptor securityInterceptor;
    //@Autowired
    //private IpInterceptor ipInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // registry.addInterceptor(ipInterceptor).addPathPatterns("/*");
        registry.addInterceptor(securityInterceptor).addPathPatterns("/admin/**");
    }

}
