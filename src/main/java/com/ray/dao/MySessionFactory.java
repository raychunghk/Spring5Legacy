package com.ray.dao;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("classpath:application.properties")
public class MySessionFactory {
    @Autowired
    public MySessionFactory(Environment env) {
        this.env = env;
    }


    public Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public SessionFactory buildSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();


        //String packagename = env.getProperty("entitypackage");

        String packagename;
        packagename = env.getProperty("entitypackage");
        //packagename = "com.ray.springdata.entity";

        //packagename =   PropertiesConfig.getPopertyValue("entitypackage");

        System.out.println("package name" + packagename);

        List<Class<?>> classes = EntityScanner
                .scanPackages(packagename).result();

        //  MetadataSources metadataSources = new MetadataSources();
        for (Class<?> annotatedClass : classes) {
            configuration.addAnnotatedClass(annotatedClass);
        }

        SessionFactory sessionFactory = configuration
                .buildSessionFactory();
        return sessionFactory;
        // register detected classes with AnnotationSessionFactoryBean
        // setAnnotatedClasses(classes.toArray(new Class[classes.size()]));
    }
    public Session getCurrentSession(){
        return buildSessionFactory().getCurrentSession();
    }
    public Session openSession(){
        return buildSessionFactory().openSession();
    }
}
