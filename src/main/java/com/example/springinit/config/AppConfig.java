package com.example.springinit.config;

import com.example.springinit.model.Employee;
import com.example.springinit.service.ICrudService;
import com.example.springinit.service.impl.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc //annotation cho phép sử dụng các config của MVC và các thư viện của nó
@Configuration //annotation đánh dấu đây là 1 file config
@ComponentScan("com.example.springinit")
//annotation đánh dấu nới IoCContainer quét qua để khởi tạo các Bean
public class AppConfig implements WebMvcConfigurer {

    @Bean //annotation đánh dấu đây là 1 Bean được quản lý
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //hành động khai báo Bean thủ công, sử dụng annotation @Bean và các phương thức tương ứng
//    @Bean
//    public ICrudService<Employee> iCrudService() {
//        return new EmployeeServiceImpl();
//    }
}
