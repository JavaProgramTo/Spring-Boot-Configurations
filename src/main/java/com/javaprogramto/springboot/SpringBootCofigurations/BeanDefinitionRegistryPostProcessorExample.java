package com.javaprogramto.springboot.SpringBootCofigurations;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class MyNewBean {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void doSomething() {
        System.out.println("MyNewBean name  " + name);
    }
}

class MyBeanRegistration
        implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
            throws BeansException {

        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setBeanClass(MyNewBean.class);
        bd.getPropertyValues().add("name", "MycustomBean");

        registry.registerBeanDefinition("myNewBean", bd);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {

    }
}

@Configuration
class MyConfig {
    @Bean
    MyBeanRegistration myConfigBean() {
        return new MyBeanRegistration();
    }
}

public class BeanDefinitionRegistryPostProcessorExample {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        MyNewBean bean = (MyNewBean) context.getBean("myNewBean");
        bean.doSomething();
    }

}