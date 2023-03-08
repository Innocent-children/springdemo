package org.example.configure;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 数据库配置类
 */
@Configuration
@PropertySource(value = "classpath:db.properties")
public class DatabaseConfiguration {
    /**
     * @Value("${jdbc.driver}") 标签作用：为成员变量赋值，<property name="" value=""></>
     * 可以是取外部属性文件中的值，也可以是基本数据类型，字符串
     */
//    @Value("${jdbc.driver}")
    @Value("com.mysql.cj.jdbc.Driver")
    private String driver;
    //    @Value("${jdbc.url}")
    @Value("jdbc:mysql://localhost:3306/springdemo")
    private String url;
    //    @Value("${jdbc.username}")
    @Value("root")
    private String username;
    //    @Value("${jdbc.password}")
    @Value("12345")
    private String password;

    /**
     * 配置DBUtils的QueryRunner对象，交由Spring ioc容器管理
     *
     * @Bean 标签作用：将配置类中方法返回值的对象，交由容器管理
     * <bean id="" class=""><bean/>
     */
    @Bean
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    /**
     * 配置DBCP的数据源BasicDataSource对象，注入spring的ioc容器
     */
    @Bean
    public DataSource createDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }
}
