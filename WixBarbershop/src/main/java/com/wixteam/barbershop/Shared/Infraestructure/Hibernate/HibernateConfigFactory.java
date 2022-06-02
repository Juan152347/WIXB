package com.wixteam.barbershop.Shared.Infraestructure.Hibernate;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfigFactory {

    @Autowired
    private Environment env;

    @Bean("session-factory")
    public LocalSessionFactoryBean sesionFactoryBean(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(this.datasource());
        sessionFactory.setHibernateProperties(this.hibernateProperties());
        //TODO: Resources
        FileSystemResource resource1 = new FileSystemResource("./src/main/java/com/wixteam/barbershop/Users/User/Infraestructure/Hibernate/User.hbn.xml");
        FileSystemResource resource2 = new FileSystemResource("./src/main/java/com/wixteam/barbershop/Admin/Infraestructure/Hibernate/Admin.hbn.xml");
        FileSystemResource resource3 = new FileSystemResource("./src/main/java/com/wixteam/barbershop/Products/Order/Infraestructure/Hibernate/Order.hbn.xml");
        FileSystemResource resource4 = new FileSystemResource("./src/main/java/com/wixteam/barbershop/Products/Product/Infraestructure/Hibernate/Product.hbn.xml");
        FileSystemResource resource5 = new FileSystemResource("./src/main/java/com/wixteam/barbershop/Services/Date/Infraestructure/Hibernate/Date.hbn.xml");
        FileSystemResource resource6 = new FileSystemResource("./src/main/java/com/wixteam/barbershop/Services/Service/Infraestructure/Hibernate/Service.hbn.xml");
        FileSystemResource resource8 = new FileSystemResource("./src/main/java/com/wixteam/barbershop/Users/Address/Infraestructure/Hibernate/Address.hbn.xml");
        sessionFactory.setMappingLocations(resource1,resource2, resource4,resource5, resource6,resource8,resource3);
        return sessionFactory;
    }
    @Bean("transactional-manager")
    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sesionFactoryBean().getObject());
        return transactionManager;
    }


    private Properties hibernateProperties(){
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO,"none");
        hibernateProperties.put(AvailableSettings.SHOW_SQL,false);
        hibernateProperties.put(AvailableSettings.DIALECT,"org.hibernate.dialect.MariaDBDialect");
        return hibernateProperties;
    }
    private DataSource datasource(){
        String url = env.getProperty("datasource.url");
        String UserName = env.getProperty("datasource.username");
        String password = env.getProperty("datasource.password");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mariadb://"+url);
        dataSource.setUsername(UserName);
        dataSource.setPassword(password);
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        return dataSource;
    }
}
