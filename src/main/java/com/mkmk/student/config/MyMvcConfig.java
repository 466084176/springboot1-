package com.mkmk.student.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 扩展SpringMvc功能
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //添加视图映射
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login.html");
        registry.addViewController("/data.html").setViewName("StudentsDetil.html");
        registry.addViewController("/add.html").setViewName("AddStudent.html");
        registry.addViewController("/cour.html").setViewName("Courses.html");
        registry.addViewController("/addcou.html").setViewName("AddCourse.html");
        registry.addViewController("/grade.html").setViewName("Student.html");
        registry.addViewController("/score.html").setViewName("AddScore.html");
}

    //                                         拦截任意请求               排除这些请求
    //注册拦截器 new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/Log/check")、
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/Log/check");
    }
}
