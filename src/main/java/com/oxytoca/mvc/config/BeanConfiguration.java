package com.oxytoca.mvc.config;

import com.oxytoca.mvc.employee.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.oxytoca.mvc")
public class BeanConfiguration {
    @Bean
    public Employee employee1() {
        return new Employee("Вероника Меньшина", "Sber", 111);
    }
}
