package com.test.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
//相当于三个注解@Configuration @EnableAutoConfiguration @ComponentSacn
//@Configuration相当于创建了spring-config.xml文件
//@ComponentSacn自动扫描当前类所在包及其子包（可以指定扫描范围）
//@ComponentScan(basePackages = "com.test.boot.controller")
@PropertySource("classpath:test.properties")   //加载自定义的配置文件
@EnableTransactionManagement //开启事务管理
@MapperScan(basePackages = "com.test.boot.dao")  //扫描mapper
public class TestBootStarter {
    public static void main(String[] args) {
        SpringApplication.run(TestBootStarter.class, args);
    }

    public static final String transactionExcution = "execution (* com.test.boot.service..*(..))";

    @Autowired
    private DataSource dataSource;

    //声明式事务
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(transactionExcution);
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        Properties attributes = new Properties();
//        attributes.setProperty("get*","PROPAGATION_REQUIRED");get不需要事务
        attributes.setProperty("add*","PROPAGATION_REQUIRED, -Execption");
        attributes.setProperty("update*","PROPAGATION_REQUIRED, -Execption");
        attributes.setProperty("delete*","PROPAGATION_REQUIRED, -Execption");
        TransactionInterceptor txAdvice = new TransactionInterceptor(new DataSourceTransactionManager(dataSource),attributes);
        advisor.setAdvice(txAdvice);
        return advisor;
    }

//    @Bean  //如果某个类或某个框架没有与SpringBoot整合  手动写它的bean

}
